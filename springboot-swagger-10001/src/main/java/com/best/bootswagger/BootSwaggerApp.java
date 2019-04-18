package com.best.bootswagger;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableSwagger2Doc
public class BootSwaggerApp {
    public static void main(String[] args) {
        SpringApplication.run(BootSwaggerApp.class);
    }
}
/**
 * https://github.com/SpringForAll/spring-boot-starter-swagger
 * - swagger.enabled=是否启用swagger，默认：true
 * - swagger.title=标题
 * - swagger.description=描述
 * - swagger.version=版本
 * - swagger.license=许可证
 * - swagger.licenseUrl=许可证URL
 * - swagger.termsOfServiceUrl=服务条款URL
 * - swagger.contact.name=维护人
 * - swagger.contact.url=维护人URL
 * - swagger.contact.email=维护人email
 * - swagger.base-package=swagger扫描的基础包，默认：全扫描
 * - swagger.base-path=需要处理的基础URL规则，默认：/**
 * - swagger.exclude-path=需要排除的URL规则，默认：空
 * - swagger.host=文档的host信息，默认：空
 * - swagger.globalOperationParameters[0].name=参数名
 * - swagger.globalOperationParameters[0].description=描述信息
 * - swagger.globalOperationParameters[0].modelRef=指定参数类型
 * - swagger.globalOperationParameters[0].parameterType=指定参数存放位置,可选header,query,path,body.form
 * - swagger.globalOperationParameters[0].required=指定参数是否必传，true,false
 */
