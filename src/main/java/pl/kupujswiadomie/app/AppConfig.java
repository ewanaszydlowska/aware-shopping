package pl.kupujswiadomie.app;

import java.util.Locale;

import javax.persistence.EntityManagerFactory;
import javax.servlet.MultipartConfigElement;
import javax.validation.Validator;

import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import pl.kupujswiadomie.converter.CategoryConverter;
import pl.kupujswiadomie.converter.ProducerConverter;
import pl.kupujswiadomie.converter.StoreConverter;
import pl.kupujswiadomie.converter.SubcategoryConverter;

//import pl.coderslab.exam6.converter.UserConverter;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "pl.kupujswiadomie.bean", "pl.kupujswiadomie.controller",
		"pl.kupujswiadomie.entity" })
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"pl.kupujswiadomie.repository"})
public class AppConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
		emfb.setPersistenceUnitName("aware_shopping");
		return emfb;
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager tm = new JpaTransactionManager(emf);
		return tm;
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(getCategoryConverter());
		registry.addConverter(getSubcategoryConverter());
		registry.addConverter(getProducerConverter());
		registry.addConverter(getStoreConverter());
	}
	
	@Bean
	public CategoryConverter getCategoryConverter() {
		return new CategoryConverter();
	}
	
	@Bean
	public SubcategoryConverter getSubcategoryConverter() {
		return new SubcategoryConverter();
	}
	
	@Bean
	public ProducerConverter getProducerConverter() {
		return new ProducerConverter();
	}
	
	@Bean
	public StoreConverter getStoreConverter() {
		return new StoreConverter();
	}

	@Bean(name = "localeResolver")
	public LocaleContextResolver getLocaleContextResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(new Locale("pl", "PL"));
		return localeResolver;
	}

	@Bean
	public Validator validator() {
	return new LocalValidatorFactoryBean();
	}
	
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("128KB");
        factory.setMaxRequestSize("128KB");
        return factory.createMultipartConfig();
    }
}
