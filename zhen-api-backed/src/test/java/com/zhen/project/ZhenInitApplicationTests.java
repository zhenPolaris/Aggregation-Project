package com.zhen.project;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

@SpringBootTest
class ZhenInitApplicationTests {

    @Test
    void contextLoads() {
//        long l = System.currentTimeMillis();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-01");
//        String format = dateFormat.format(l);
//        System.out.println(format);
        countS(3.0,4.0,5.0);

    }

    public static void countS(double a,double b ,double c){
        double d = ((a*a)*(b*b)-Math.pow((a*a+b*b-c*c)/2,2))/4;
        double result = Math.sqrt(d);
        System.out.println(result);
    }

}
