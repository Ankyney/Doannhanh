package com.tthshop.config;

import java.util.Locale;
import java.util.Properties;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
public class WebMVCConfig extends WebMvcConfigurerAdapter {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
//		registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
	}
	@Bean(name = "messageSource")
	   public MessageSource getMessageResource()  {
	       ReloadableResourceBundleMessageSource messageResource= new ReloadableResourceBundleMessageSource();
	  
	        
	       // Đọc vào file i18n/messages_xxx.properties
	       // Ví dụ: i18n/message_en.properties
	       messageResource.setBasename("classpath:i18n/messages");
	       messageResource.setDefaultEncoding("UTF-8");
	       return messageResource;
	   }
	    
	   @Bean(name = "localeResolver")
	   public LocaleResolver getLocaleResolver()  {
	       CookieLocaleResolver resolver= new CookieLocaleResolver();
	       resolver.setCookieDomain("myAppLocaleCookie");
	     
	       // 60 phút.
	       resolver.setCookieMaxAge(60*60);
	       return resolver;
	   }
	   @Override
	   public void addInterceptors(InterceptorRegistry registry) {
	       LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
	       localeInterceptor.setParamName("lang");
	     
	     
	       registry.addInterceptor(localeInterceptor).addPathPatterns("/*");
	   }
	   
	   @Bean
	   public JavaMailSender getJavaMailSender() {
	       JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	       mailSender.setHost("smtp.gmail.com");
	       mailSender.setPort(587);
	        
	       mailSender.setUsername("ankyney@gmail.com");
	       mailSender.setPassword("tien1999nhaa");
	        
	       Properties props = mailSender.getJavaMailProperties();
	       props.put("mail.transport.protocol", "smtp");
	       props.put("mail.smtp.auth", "true");
	       props.put("mail.smtp.starttls.enable", "true");
	       props.put("mail.debug", "true");
	        
	       return mailSender;
	   }
}