package br.edu.ifsp.prw3.p3;

/* Luigi Vanzella 
   Hugo Camargo */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class P3Application {

	public static void main(String[] args) {
		SpringApplication.run(P3Application.class, args);
	}

}
