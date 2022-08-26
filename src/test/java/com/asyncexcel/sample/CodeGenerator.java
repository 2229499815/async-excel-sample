package com.asyncexcel.sample;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import java.util.Collections;

/**
 * @Description TODO
 * @Author 姚仲杰#80998699
 * @Date 2022/8/26 15:40
 */
public class CodeGenerator {
    public final static String JDBC_URL="jdbc:mysql://localhost:3306/async-excel-sample?serverTimezone=GMT%2B8&autoReconnect=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&&useCursorFetch=true&&rewriteBatchedStatements=true";
    public final static String USERNAME="root";
    public final static String PASSWORD="root";
    
    public static void main(String[] args) {
    
        String baseDir = System.getProperty("user.dir");
        
       ;
        FastAutoGenerator.create(JDBC_URL, USERNAME, PASSWORD)
            .globalConfig(builder -> {
                builder.author("姚仲杰") // 设置作者
                    .fileOverride() // 覆盖已生成文件
                    .outputDir(baseDir+ "/src/main/java"); // 指定输出目录
            })
            .packageConfig(builder -> {
                builder.parent("com.asyncexcel.sample") // 设置父包名
                    .pathInfo(Collections.singletonMap(OutputFile.xml, baseDir+ "/src/main/resources/mapper")); // 设置mapperXml生成路径
            })
            .strategyConfig(builder -> {
                builder.addInclude("u_user") // 设置需要生成的表名
                .addTablePrefix("u_");
            })
            .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
            .execute();
    }
}
