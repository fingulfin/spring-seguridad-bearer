package educarvr.spring_seguridad_bearer;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://srv484.hstgr.io/u375466133_c5Hvp");
        dataSourceBuilder.username("u375466133_gMGwk");
        dataSourceBuilder.password("Gera2024v2");
        return dataSourceBuilder.build();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/resource/**").hasAnyAuthority("ADMIN")
                        .anyRequest().authenticated()

                )
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        /*  La primera vez generas el UserDetal y los agregas al  dataSource con el
           createUser, ya despues no es neesrio por eso estan comentados.

        UserDetails user1 = User.withDefaultPasswordEncoder()
                .username("juan")
                .password("topo")
                .roles("USER")
                .build();
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("conejo")
                .roles("USER", "ADMIN")
                .build();
*/
       // System.out.println("ESTO SE EJECUTA AL  HACER LA AUTENTICACION PSWD: "+user1.getPassword());
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(getDataSource());
      // users.createUser(user1);
      //  users.createUser(admin);
       // return new InMemoryUserDetailsManager(userDetails);
        return users;
    }

}