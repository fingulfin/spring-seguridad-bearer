package educarvr.spring_seguridad_bearer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSeguridadBearerApplication implements CommandLineRunner {
@Autowired RepoLibro repoLibro;
	public static void main(String[] args) {
		SpringApplication.run(SpringSeguridadBearerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hola mundo desdel main");
		for(Libro libro:repoLibro.findAll()){
			System.out.println("Titulo :"+libro.getNombre());
		}
	}
}
