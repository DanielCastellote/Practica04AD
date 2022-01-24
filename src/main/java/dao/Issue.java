package dao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "issue")
@NamedQuery(name = "Issue.findAll", query = "SELECT c FROM Issue c")
public class Issue {
    private long id;
    private String titulo;
    private String texto;
    private Date fCreacion;
    private String estado;
    private Repositorio repositorio;

    public Issue(String titulo, String texto, String estado) {
        this.titulo = titulo;
        this.texto = texto;
        this.estado = estado;
        this.fCreacion= new Date(System.currentTimeMillis());
        this.repositorio= new Repositorio();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }
    @Basic
    @Column(name = "titulo", nullable = false, length = 100)
    public String getTitulo() {
        return titulo;
    }
    @Basic
    @Column(name = "texto", nullable = false, length = 100)
    public String getTexto() {
        return texto;
    }
    @Basic
    @Column(name = "fCreacion", nullable = false, length = 100)
    public Date getfCreacion() {
        return fCreacion;
    }
    @Basic
    @Column(name = "estado", nullable = false, length = 100)
    public String getEstado() {
        return estado;
    }
    @ManyToOne
    @JoinColumn(name = "repositorio_id", referencedColumnName = "id", nullable = false)
    public Repositorio getRepositorio() {
        return repositorio;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setfCreacion(Date fCreacion) {
        this.fCreacion = fCreacion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setRepositorio(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", texto='" + texto + '\'' +
                ", fCreacion=" + fCreacion +
                ", estado='" + estado + '\'' +
                '}';
    }
}
