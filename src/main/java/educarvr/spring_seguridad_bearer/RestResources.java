package educarvr.spring_seguridad_bearer;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/resource")
public class RestResources {


    @RequestMapping("/resource")
    public Map<String,Object> home() {
        Map<String,Object> model = new HashMap<String,Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello World");
        return model;
    }


    @GetMapping("/recurso1")
    public String recurso1(){
        return "Primer recurso de administradores";

    }

    @GetMapping("/recurso2")
    public String recurso2(){
        return "SEgundo recurso recurso";

    }
}
