package educarvr.spring_seguridad_bearer;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepoUsuario extends MongoRepository<Usuario, Long> {


}
