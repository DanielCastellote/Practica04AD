package dao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tecnologia")
@NamedQuery(name = "Tecnologia.findAll", query = "SELECT c FROM Tecnologia c")
public class Tecnologia {

    private long id;
    private String nombre;
    private Programador programador;

    public Tecnologia(String nombre, Programador programador) {
        this.nombre = nombre;
        this.programador = programador;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }
    @Basic
    @Column(name = "nombre", nullable = false, length = 100)
    public String getNombre() {
        return nombre;
    }
    @ManyToOne
    @JoinColumn(name = "programador_id", referencedColumnName = "id", nullable = false)
    public Programador getProgramador() {
        return programador;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProgramador(Programador programador) {
        this.programador = programador;
    }

    @Override
    public String toString() {
        return "Tecnologia{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
