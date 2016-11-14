package fr.lteconsulting.angular2gwt.demos.memos.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import fr.lteconsulting.angular2gwt.demos.memos.shared.Memo;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan( basePackageClasses = ApplicationController.class )
public class ApplicationController
{
	public static void main( String[] args ) throws Exception
	{
		SpringApplication.run( ApplicationController.class, args );
	}

	@Bean
	@Scope( WebApplicationContext.SCOPE_APPLICATION )
	public MemosRepository createMemosRepository()
	{
		MemosRepository memosRepository = new MemosRepository();

		Memo sample = new Memo();
		sample.title = "This is a sample memo";
		sample.description = "It was made for the wonderful GWTCon";
		memosRepository.createOrUpdate( sample );

		return memosRepository;
	}
}