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
        /**
         * 1. 生产代码
         * 2.将生成的源代码输出到磁盘，保存为java文件
         */
        try{
            //1. 生产代码
            String proxyClass = generateCode(interfaces);

            //2.将生成的源代码输出到磁盘，保存为java文件
            String path = HaloProxy.class.getResource("").getPath();    //当前HaloProxy所在的磁盘路径，name参数不填则返回当前类所在的路径下，name 某个路径下 D:/a/b/c  name指定为b 就返回 /D:/a/b
            File f = new File(path+"$haloProxy.java");
            FileWriter fileWriter = new FileWriter(f);
            fileWriter.write(proxyClass);
            fileWriter.flush();
            fileWriter.close();

            // 3.编译源代码,并且生成class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();        // 创建一个编译器
            StandardJavaFileManager standardFileManager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = standardFileManager.getJavaFileObjects(f);

            CompilationTask  task = compiler.getTask(null,standardFileManager,null,null,null,iterable);
            task.call();                // 编译
            standardFileManager.close();

            /**
             * 4.将class文件中的内容，动态加载到JVM中来
             * 5.返回被代理后的代理对象
             */
            loader.setClassFile(path);
            Class haloProxyClass = loader.findClass("$haloProxy");
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
        String proxyClassName = "$haloProxy";
        StringBuilder sb = new StringBuilder();
        sb.append("package ");
        sb.append(HaloProxy.class.getPackage().getName()).append(";").append(ln);
        sb.append("import ").append(Method.class.getName()).append(";").append(ln);
        sb.append("public class ").append(proxyClassName).append(" implements ");
        for(int index = 0;index < interfaces.length;index++){
            sb.append(interfaces[index].getName());
            if(index != interfaces.length -1){
                sb.append(",");
            }
        }
        sb.append("{").append(ln);
        sb.append(HaloInvocationHandler.class.getName()).append(" h;").append(ln);
        sb.append("public ").append(proxyClassName).append("(").append(HaloInvocationHandler.class.getName()).append(" h")
                .append("){").append(ln);
        sb.append("this.h = h;").append(ln);
        sb.append("}").append(ln);

       for(Class<?> clazz : interfaces){
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
