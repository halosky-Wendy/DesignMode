package com.halosky.springTest;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.util.*;

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
    public void testEnvironment(){

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath*:/resource/applicationContext.xml;${JAVA_HOME}");
        Environment environment = classPathXmlApplicationContext.getEnvironment();
        Map<String, Object> systemEnvironment = ((ConfigurableEnvironment) environment).getSystemEnvironment();             // 获取系统环境
        Map<String, Object> stringObjectMap = ((ConfigurableEnvironment) environment).getSystemProperties();                // 获取系统属性

        System.out.println(systemEnvironment);
        System.out.println("------------------------------");
        System.out.println(stringObjectMap);
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
