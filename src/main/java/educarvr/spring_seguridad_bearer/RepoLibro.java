package educarvr.spring_seguridad_bearer;


import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoLibro extends JpaRepository<Libro, Long> {
}
