package com.ascii274.login.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration
@ComponentScan("com.ascii274.login")
public class CustomConfig implements WebMvcConfigurer, ApplicationContextAware {

    private static final Logger log = LoggerFactory.getLogger((CustomConfig.class));
    private ApplicationContext applicationContext;

    public CustomConfig(){
        super();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;

    }

    /**
     * SpringResourceTemplateResolver
     * Fuctional
     */
    @Bean
    public SpringResourceTemplateResolver firstTemplateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("./webapp/WEB-INF/view/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setOrder(0);
        templateResolver.setCheckExistence(true);
        return templateResolver;
    }

    /**
     * NOT tested
     */
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("/images/**").addResourceLocations("webapp/images/");
        registry.addResourceHandler("/webapp/css/**").addResourceLocations("/webapp/css/");
        registry.addResourceHandler("/view/**").addResourceLocations("webapp/js/");
    }

    //ClassLoaderTemplateResolver
//    @Bean
//    public ClassLoaderTemplateResolver yourTemplateResolver() {
//        ClassLoaderTemplateResolver configurer = new ClassLoaderTemplateResolver();
//        configurer.setPrefix("./webapp/WEB-INF/templates/");
//        configurer.setSuffix(".html");
//        configurer.setTemplateMode(TemplateMode.HTML);
//        configurer.setCharacterEncoding("UTF-8");
//        configurer.setOrder(0);  // this is important. This way spring //boot will listen to both places 0 and 1
//        configurer.setCheckExistence(true);
//        return configurer;
//    }


}
