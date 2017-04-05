package com.myapp.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class httpTest {
    public Object getCities(){
    	return "hahah";
    }
    @RequestMapping(value="/getCityName",method=RequestMethod.POST)
    public String getUserName(@RequestParam(value="name") String name){
        return name;
    }
}
