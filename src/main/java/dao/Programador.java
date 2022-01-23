package dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utils.Cifrador;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "programador")
@NamedQuery(name = "Programador.findAll", query = "SELECT c FROM Programador c")
public class Programador {

    private long id;
    private String nombre;
    private Date fAlta;
    private double salario;
    private String email;
    private String contrasena;
    private Set<Tecnologia> lenguajes;
    private Login loginProgramador;

    public Programador(String nombre, double salario, String email, String contrasena) {
        this.nombre = nombre;
        this.fAlta = new Date(System.currentTimeMillis());
        this.salario = salario;
        this.email = email;
        this.contrasena = Cifrador.getInstance().SHA256(contrasena);
        this.lenguajes = new HashSet<>();
        this.loginProgramador = new Login();
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

    public Date getfAlta() {
        return fAlta;
    }

    public double getSalario() {
        return salario;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public Set<Tecnologia> getLenguajes() {
        return lenguajes;
    }

    public Login getLoginProgramador() {
        return loginProgramador;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setfAlta(Date fAlta) {
        this.fAlta = fAlta;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setLenguajes(Set<Tecnologia> lenguajes) {
        this.lenguajes = lenguajes;
    }

    public void setLoginProgramador(Login loginProgramador) {
        this.loginProgramador = loginProgramador;
    }
}
