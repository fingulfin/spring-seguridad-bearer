package educarvr.spring_seguridad_bearer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/rest/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;

    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody LoginReq loginReq) {

        try {

            //1.  Autenticamos, aqui se activa el bean AuthenticationManager que se enuentra en SecurityConfi
            //     y a su vez alli en ese bean se invoca el UserDetailsService en el bean AuthenticationManager
            //    el UserDetailSrvice personalizado tiene como funcion  dar los detalles del usuario a autenticar
            //     en este Bean userDetailService se carga el usuario, , por ejemplo de una base de datos se encuentra por su metodo findBy, ligado a su repositorio.
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReq.getEmail(), loginReq.getPassword()));
            //2. Generamos el token
            String email = authentication.getName();
            User user = new User(email, "");
            String token = jwtUtil.createToken(user);
            //3. Creamos la respuesta de autenticcion, aqui quedan expuestas ya las Rest api autenticadas
            //   Para ello debemos d enviar en cada request enviar un Authorizacon de ipo bearer con el token para acceder a dichas REST api's
            LoginRes loginRes = new LoginRes(email, token);

            return ResponseEntity.ok(loginRes);

        } catch (BadCredentialsException e) {
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, "Invalid username or password");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        } catch (Exception e) {
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }





    @GetMapping("/hola")
    public String hola() {
        return "Hola mundoooo";
    }


    @GetMapping("/holasa")
    public String method(Authentication authentication) {
        if (authentication instanceof AnonymousAuthenticationToken) {
            return "anonymous";
        } else {
            return "not anonymous";
        }
    }
}
