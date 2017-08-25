package com.kaitaiming.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;


public class Main {
	
    public final static String fileDir = "C:/Users/DevUser/Desktop";
    public final static String name = "consumer.txt";
    public static void main(String[] args) {
    }

    public static void test (Object a){
    	if(a != null){
    		System.out.println(a.toString());
    		return;
    	}
    }
    public static void getExisListToFile(String fileName) {
        File f = new File(fileDir, name);
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(f), "GBK"));
            if (!StringUtils.isEmpty(fileName)) {
                bw = new BufferedWriter(new FileWriter(new File(fileName)));
            }
            String str = null;
            String claim = null;
            
            
            while ((str = br.readLine()) != null) {
            	
            	claim+=str;
            	
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (bw != null) {
                    bw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
   
}
