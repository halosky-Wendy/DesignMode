package com.halosky.Proxy.ManualProxy.halosky;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @Author YangHuan
 * @Date 2019/1/19 11:26
 **/
public class HaloClassLoader extends ClassLoader {

    private File classPath ;

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = HaloClassLoader.class.getPackage().getName()+"."+name;
        if(null != classPath){
            File classFile = new File(classPath,name.replaceAll("\\.","/")+".class");
            if(classFile.exists()){
                FileInputStream fileInputStream = null;
                ByteArrayOutputStream byteArrayOutputStream = null;
                try{
                    fileInputStream = new FileInputStream(classFile);
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = fileInputStream.read(buffer)) != -1){
                        byteArrayOutputStream.write(buffer,0,len);
                    }
                    return defineClass(className,byteArrayOutputStream.toByteArray(),0,byteArrayOutputStream.size());
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    if(null != fileInputStream){
                        try {
                            fileInputStream.close();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    if(null != byteArrayOutputStream){
                        try {
                            byteArrayOutputStream.close();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }else{
            throw new ClassNotFoundException("not found proxy class file");
        }
        return super.findClass(name);
    }

    public void setClassFile(String sourcePath){
        this.classPath = new File(sourcePath);
    }
}
