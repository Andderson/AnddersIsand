package com.myapp.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myapp.service.UserService;

/**
 * @version V1.0
 */
public class ExportTaiheJson {

    private ApplicationContext ac = null;
    private UserService userService;    
    
    @Before
    public void before(){
         //使用"spring-context.xml"和"spring-mybatis.xml"这两个配置文件创建Spring上下文
         ac = new ClassPathXmlApplicationContext(new String[]{"spring-context.xml","spring-mybatis.xml"});
         //从Spring容器中根据bean的id取出我们要使用的userService对象
         userService = (UserService) ac.getBean("userService");
    }
    
    @Test
    public void exportYingDa(){
        
        
        
        
    }
}
