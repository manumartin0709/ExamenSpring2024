package es.psp.martin_murillo_unidad1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "es.psp.martin_murillo_unidad1")
public class MartinMurilloUnidad1Application 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(MartinMurilloUnidad1Application.class, args);
	}

}
