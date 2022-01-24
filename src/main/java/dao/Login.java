package dao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "login")
@NamedQuery(name = "Login.findAll", query = "SELECT c FROM Login c")
public class Login {

    private long id;
    private Timestamp instIdentificacion;
    private long token;
    private boolean activo;

    public Login(long token, boolean activo) {
        this.instIdentificacion= new Timestamp(System.currentTimeMillis());
        this.token = token;
        this.activo = activo;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    @Basic
    @Column(name = "instIdentificacion", nullable = false, length = 100)
    public Timestamp getInstIdentificacion() {
        return instIdentificacion;
    }

    @Basic
    @Column(name = "token", nullable = false, length = 100)
    public long getToken() {
        return token;
    }

    @Basic
    @Column(name = "activo", nullable = false, length = 100)
    public boolean isActivo() {
        return activo;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setInstIdentificacion(Timestamp instIdentificacion) {
        this.instIdentificacion = instIdentificacion;
    }

    public void setToken(long token) {
        this.token = token;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", instIdentificacion=" + instIdentificacion +
                ", token=" + token +
                ", activo=" + activo +
                '}';
    }
}
