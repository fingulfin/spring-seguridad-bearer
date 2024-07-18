package educarvr.spring_seguridad_bearer;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class RestResources {


    @GetMapping("/recurso1")
    public String recurso1(){
        return "Primer recurso de administradores";

    }

    @GetMapping("/recurso2")
    public String recurso2(){
        return "SEgundo recurso recurso";

    }
}
