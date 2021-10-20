package com.hy.fmp.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.hy.fmp.dto.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;

import java.util.HashMap;

@EnableOpenApi
@Configuration
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

  @Value("${knife4j.enable:true}")
  private boolean enable;

  @Bean
  UiConfiguration uiConfig() {
    return UiConfigurationBuilder.builder().build();
  }

  @Bean
  public Docket nlpRestApi(ServerProperties serverProperties) {
    return new Docket(DocumentationType.OAS_30)
        .enable(enable)
        .apiInfo(apiInfo("FluentMybatis测试服务接口"))
        .pathMapping(serverProperties.getServlet().getContextPath())
        .groupName("FluentMybatis测试")
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.hy.fmp.ctrl"))
        .paths(PathSelectors.any())
        .build();
  }

  private ApiInfo apiInfo(String title) {
    return new ApiInfoBuilder()
        // 标题
        .title(title)
        // 描述
        .description("所有的接口响应在现有接口定义外包装了一层标准结构:" + Result.ok(new HashMap<>(1)))
        // 作者信息
        .contact(new Contact("剑客阿良ALiang", "", "3614322595@qq.com"))
        // 版本号
        .version("1.0.0")
        .build();
  }
}
