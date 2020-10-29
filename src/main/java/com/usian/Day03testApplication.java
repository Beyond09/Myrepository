package com.usian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.usian.dao")//注意MapperScan要导tk的包，不然会报NoSuchMethodException
public class Day03testApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day03testApplication.class, args);
    }

}
