package educarvr.spring_seguridad_bearer;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Libro {

    @Id
    Long isbn;
    String nombre;

    public Libro(Long isbn, String nombre) {
        this.isbn = isbn;
     this.nombre=nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }



    public Libro() {
    }
}
