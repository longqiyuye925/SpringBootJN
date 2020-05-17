package com.bjsxt.springbootdemo.config;

import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.PlatformResourceBundleLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;

/**
 * @Description: 自定义校验文件的路径和名称，默认是ValidationMessages.properties文件，放在resources目录下
 * @author: wsc
 * @Param:
 * @Return:
 * @Date: 2020 05 2020/5/17
 */
@Configuration
public class ValidationConfig {
    @Bean
    public javax.validation.Validator getValidator() {
        Validator validator = Validation.byDefaultProvider().
                configure().
                messageInterpolator(new ResourceBundleMessageInterpolator(new PlatformResourceBundleLocator("i18n/validation/cutomerValidationMessage"))).
                buildValidatorFactory().getValidator();
        return validator;
    }
}
