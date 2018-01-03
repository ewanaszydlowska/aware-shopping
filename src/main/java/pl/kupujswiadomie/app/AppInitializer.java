package pl.kupujswiadomie.app;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext container) throws ServletException {
		
		AnnotationConfigWebApplicationContext ctx =	new AnnotationConfigWebApplicationContext();	//kontekst aplikacji
		ctx.register(AppConfig.class);																//wybór klasy będacej kontekstem
		ctx.setServletContext(container);															//srodowisko gdzie dzialają servlety(kontener servletów)
		ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));	//główny servlet obslugujacy całą apke
		servlet.setLoadOnStartup(1);																			//uruchomi sie przy starcie app, gdy (-1) to uruchamia sie po 1 requeście
		servlet.addMapping("/");																	//adres 
}
}
