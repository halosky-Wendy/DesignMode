package com.halosky.springTest;

import com.halosky.springTest.entity.ExpandClassPathXmlApplicationContext;
import com.halosky.springTest.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.EnvironmentCapable;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.AntPathMatcher;

import java.net.URL;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author YangHuan
 * @Date 2019/3/1 15:46
 **/
public class SpringSetConfigsTest {

    String CONFIG_LOCATION_DELIMITERS = ",; \t\n";

    String[] configs = null;

    @Test
    public void testSplit(){
        String artgs= "$$231#123**erqwre";
        StringTokenizer stringTokenizer = new StringTokenizer(artgs,"#$*");
        while (stringTokenizer.hasMoreTokens()){
            System.out.println(stringTokenizer.nextToken());
        }
    }

    @Test
    public void testStringMethod (){
        String url = "qweqwrqrwqwrq12314124.jps";
        System.out.println(url.endsWith(".jps"));
    }

    @Test
    public void test(){
        String str = "classPath*:applicationContext.xml,applicationContext-beans.xml;applicationContext-aop.xml";
        String[] strings = SpringSetConfigsTest.tokenizeToStringArray(str,CONFIG_LOCATION_DELIMITERS,true,true);
        System.out.println(Arrays.toString(strings));
    }


    @Test
    public void testCopyOnSet(){
        User user = new User();
        user.setName("789");
        User user1 = new User();
        user1.setName("456");
        User user3 = new User();
        user3.setName("halosky");
        Set<User> userset = new CopyOnWriteArraySet<>();
        userset.add(user);
        userset.add(user3);
        userset.add(user1);

        userset.remove(user3);
        userset.add(user3);

        for(User user2 : userset){
            System.out.println(user2.getName());
        }

    }


    @Test
    public void testCopyOnList(){
        User user = new User();
        user.setName("123");
        User user1 = new User();
        user1.setName("456");

        List<User> userList = new CopyOnWriteArrayList<>();
        userList.add(user);
        userList.add(user1);

        userList.remove(user);
        userList.add(user);
        for(User user2 : userList){
            System.out.println(user2.getName());
        }
    }


    @Test
    public void testList(){
        User user = new User();
        user.setName("123");
        User user1 = new User();
        user1.setName("456");

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user1);
        userList.remove(user);
        userList.add(user);

        userList.remove(user);
        userList.add(user);

        for(User user2 : userList){
            System.out.println(user2.getName());
        }

    }

    @Test
    public void testEnvironment(){

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath*:/resource/applicationContext.xml;${JAVA_HOME}");
        Environment environment = classPathXmlApplicationContext.getEnvironment();
        Map<String, Object> systemEnvironment = ((ConfigurableEnvironment) environment).getSystemEnvironment();             // 获取系统环境
        Map<String, Object> stringObjectMap = ((ConfigurableEnvironment) environment).getSystemProperties();                // 获取系统属性
        User user = classPathXmlApplicationContext.getBean(User.class);
        System.out.println(user.getName());

        System.out.println(systemEnvironment);
        System.out.println("------------------------------");
        System.out.println(stringObjectMap);
    }


    @Test
    public void testClassPathXmlApplicationContext(){
//        Properties properties = System.getProperties();
//        properties.setProperty("HALOSKY_HOME","123");
        ApplicationContext applicationContext = new ExpandClassPathXmlApplicationContext("classpath*:/resource/applicationContext12.xml");


    }

    @Test
    public void testDefaultListableBeanFactory(){
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        System.out.println(defaultListableBeanFactory instanceof ResourceLoader);
        System.out.println(defaultListableBeanFactory instanceof EnvironmentCapable);
    }


    @Test
    public void testApplicationContext(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:/resource/applicationContext.xml");
        Object user = applicationContext.getBean("user");
        System.out.println(user);
    }

    @Test
    public void testSet(){
        Set<Integer> set = new HashSet<>();
        set.add(1);

        Integer[] integers = (Integer[]) set.toArray();

        System.out.println(set.toArray().length);
    }

    @Test
    public void testSourcePath(){
        try {
            ClassLoader classLoader = AbstractApplicationContext.class.getClassLoader();
            URL url = classLoader.getResource("resource/applicationContext.xml");
            Enumeration<URL> enumeration = ClassLoader.getSystemResources("resource/applicationContext.xml");
            while (enumeration.hasMoreElements()){
                URL url1 = enumeration.nextElement();
                System.out.println(url1.getPath());
            }

            System.out.println(url.getPath());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test
    public void testAntPathMatcher(){
        String classPathPrefix = "classpath*:";
        String soruces = "classpath*:/resource/applicationContext.xml;classpath*:/resource/applicationContext-beans.xml";
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        String a = soruces.substring(classPathPrefix.length());
        if(a.indexOf("*") != -1 || a.indexOf("?") != -1){
            System.out.println("不包含多个资源路经");
        }else{
            System.out.println("包含多个资源路经");
        }

    }


    @Test
    public void testResolver(){
        try {
            ResourcePatternResolver resourcePatternUtils = new PathMatchingResourcePatternResolver();
            Resource[] resource = resourcePatternUtils.getResources("classpath*:/resource/applicationContext.xml");
            if (resource.length > 0) {
                Resource resource1 = resource[0];
                System.out.println(resource1.getFile().getPath());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @param str                 configs
     * @param delimiters         分隔符
     * @param trimTokens         清空空格
     * @param ignoreEmptyTokens 忽略空标记
     * @return
     */
    public static String[] tokenizeToStringArray(
             String str, String delimiters, boolean trimTokens, boolean ignoreEmptyTokens) {

        if (str == null) {
            return new String[0];
        }

        StringTokenizer st = new StringTokenizer(str, delimiters);
        List<String> tokens = new ArrayList<>();
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (trimTokens) {
                token = token.trim();
            }
            if (!ignoreEmptyTokens || token.length() > 0) {
                tokens.add(token);
            }
        }
        return toStringArray(tokens);
    }

    public static String[] toStringArray(Collection<String> collection) {
        return collection.toArray(new String[0]);
    }

}
