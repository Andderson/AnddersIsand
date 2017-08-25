package com.kaitaiming.container;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kaitaiming.injured.dynamicformservice.service.TaskService;

public class Container {
    private static ClassPathXmlApplicationContext ac;
    static{
        ac = new ClassPathXmlApplicationContext( new String[] { "spring.xml", "spring-dubbox.xml" });
    }
    public static void showBeanName(){
    	
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for(int i=0;i<beanDefinitionNames.length;i++){
            System.out.println(beanDefinitionNames[i]);
        }
    }
    
    public static TaskService getTaskService(){
    	return (TaskService) ac.getBean("TaskServiceImp");
    } 
    public static void main(String[] args) {
    	TaskService a = getTaskService();
    	Map<String, Object> map = new HashMap<String,Object>();
    	 map.put("offSet", 0);
         map.put("pageSize", 20);
         map.put("taskDate", "2017-08-24");
         map.put("updateTime", "2017-08-24 23:59:59");
         map.put("taskState", 0);
         map.put("taskUserId", 1025);
         map.put("isToday", 1);
//		 String lists = a.getTaskList(map);
		 a.getTaskListCount(map);
		 System.out.println(a.getTaskListCount(map));
//		 System.out.println(lists);
    }
    
    
      
}
