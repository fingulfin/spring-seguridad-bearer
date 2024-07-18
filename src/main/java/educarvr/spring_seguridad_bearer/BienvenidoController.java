package educarvr.spring_seguridad_bearer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BienvenidoController {

    @GetMapping("/")
    public String Bienvenido(){
        return "Bienvenido";
    }

}
