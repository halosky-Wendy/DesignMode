package com.halosky.Proxy.ManualProxy.halosky;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @Author YangHuan
 * @Date 2019/1/19 11:28
 **/
public class HaloProxy {

    /**
     *  生成代理对象
     * @param loader
     * @param interfaces
     * @param h
     * @return
     * @throws IllegalArgumentException
     */
    public static Object newProxyInstance(HaloClassLoader loader, Class<?>[] interfaces,HaloInvocationHandler h)
            throws IllegalArgumentException {
        try{
            //1. 生产代码
            String proxyClass = generateCode(interfaces);

            //2.将生成的源代码输出到磁盘，保存为java文件
            String path = HaloProxy.class.getResource("").getPath();
            File f = new File(path+"$haloProxy.java");
            FileWriter fileWriter = new FileWriter(f);
            fileWriter.write(proxyClass);
            fileWriter.flush();
            fileWriter.close();

            // 3.编译源代码,并且生成class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();                               // 创建一个编译器
            // 获取一个文件管理器
            StandardJavaFileManager standardFileManager = compiler.getStandardFileManager(null, null, null);        // 获取一个文件管理器
            Iterable iterable = standardFileManager.getJavaFileObjects(f);
            // CompilationTask代表编译任务
            CompilationTask  task = compiler.getTask(null,standardFileManager,null,null,null,iterable);
            task.call();                // 编译
            standardFileManager.close();

            /**
             * 4.将class文件中的内容，动态加载到JVM中来
             *
             */
            loader.setClassFile(path);
            Class haloProxyClass = loader.findClass("$haloProxy");

            //5.返回被代理后的代理对象
            Constructor c = haloProxyClass.getConstructor(HaloInvocationHandler.class);

            return c.newInstance(h);

        }catch (Exception e){
            e.printStackTrace();
        }


        return null;
    }

    /**
     * 生成代码
     * @param interfaces  被代理类所实现的接口
     * @return
     */
    public static String generateCode( Class<?>[] interfaces){
        String ln = "\r\n";
        String proxyClassName = "$haloProxy";                                           // 我们生成类的类名
        StringBuilder sb = new StringBuilder();
        sb.append("package ");
        sb.append(HaloProxy.class.getPackage().getName()).append(";").append(ln);       // 包名
        sb.append("import ").append(Method.class.getName()).append(";").append(ln);    // 我们代理类中需要使用到Method，所以需要导入包
        sb.append("public class ").append(proxyClassName).append(" implements ");    //  实现的接口，这里我们传的是一个数组(Class<?>[] interfaces)
        for(int index = 0;index < interfaces.length;index++){
            sb.append(interfaces[index].getName());
            if(index != interfaces.length -1){
                sb.append(",");
            }
        }
        sb.append("{").append(ln);
        sb.append(HaloInvocationHandler.class.getName()).append(" h;").append(ln);     //  这里就是我们的InvocationHandler，作为成员变量写出来
        sb.append("public ").append(proxyClassName).append("(").append(HaloInvocationHandler.class.getName()).append(" h")
                .append("){").append(ln);
        sb.append("this.h = h;").append(ln);
        sb.append("}").append(ln);                                                      // 构造函数，需要传入InvocationHandler

       for(Class<?> clazz : interfaces){                                                // 迭代接口中的方法
           for(Method m : clazz.getMethods()){
                sb.append("public ").append(m.getReturnType().getName()).append(" ").
                        append(m.getName()).append(" (){").append(ln);
                sb.append("try{").append(ln);
                sb.append(Method.class.getName()).append(" m = ").append(clazz.getName()).append(".class.getMethod(\"")
                .append(m.getName()).append("\",new Class[]{});").append(ln);
                sb.append("this.h.invoke(this,m,null);").append(ln);
               sb.append("}catch(Throwable e){e.printStackTrace();}" + ln);
               sb.append("}" + ln);
           }
       }
        sb.append("}");
        return sb.toString();
    }

}
