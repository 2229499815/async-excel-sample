package com.asyncexcel.sample;

import com.asyncexcel.springboot.EnableAsyncExcel;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAsyncExcel
@MapperScan({"com.asyncexcel.sample.mapper"})
public class AsyncExcelSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsyncExcelSampleApplication.class, args);
    }

}
