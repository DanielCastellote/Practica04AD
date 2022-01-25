package dao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "commit")
@NamedQuery(name = "Commit.findAll", query = "SELECT c FROM Commit c")
public class Commit {

    private long id;
    private String titulo;
    private String texto;
    private Date fCreacion;
    private Programador autor;
    private Repositorio repositorio;

    @ManyToOne
    @JoinColumn(name = "programador_id")
    private Programador programador;

    public Programador getProgramador() {
        return programador;
    }

    public void setProgramador(Programador programador) {
        this.programador = programador;
    }


    public Commit(String titulo, String texto, Date fCreacion, Programador autor, Repositorio repositorio) {
        this.titulo = titulo;
        this.texto = texto;
        this.fCreacion = fCreacion;
        this.autor = autor;
        this.repositorio = repositorio;
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
    @ManyToOne
    @JoinColumn(name = "programador_id", referencedColumnName = "id", nullable = false)
    public Programador getAutor() {
        return autor;
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

    public void setAutor(Programador autor) {
        this.autor = autor;
    }

    public void setRepositorio(Repositorio repositorio) {
        this.repositorio = repositorio;
    }
}
