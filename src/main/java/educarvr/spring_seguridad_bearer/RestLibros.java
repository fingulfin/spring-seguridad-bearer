package educarvr.spring_seguridad_bearer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/rest/libro")
public class RestLibros {

    @Autowired RepoLibro repoLibro;

    @GetMapping("/libros")
        public List<Libro> getLibros(){
        return repoLibro.findAll();
        }
}
