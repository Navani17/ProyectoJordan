package gradle.cucumber;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Lente {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="modelo")
    private String modelo;

    @Column(name="precio")
    private int precio;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String marca) {
        this.modelo = marca;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }


    @Override
    public String toString() {
        return this.modelo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lente item = (Lente) o;
        return Objects.equals(id, item.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
