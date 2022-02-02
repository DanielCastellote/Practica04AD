package dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "login")
@NamedQuery(name = "Login.findAll", query = "SELECT c FROM Login c")
public class Login {

    private long id;
    private Timestamp instSalida;
    private String token;
    private boolean activo;


    @Id
    public long getId() {
        return id;
    }

    @Basic
    @Column(name = "ultimo_acceso", nullable = false)
    public Timestamp getInstSalida() {
        return instSalida;
    }

    @Basic
    @Column(name = "token", nullable = false, length = 100)
    public String getToken() {
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

    public void setInstSalida(Timestamp instSalida) {
        this.instSalida = instSalida;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", instSalida=" + instSalida +
                ", token='" + token + '\'' +
                ", activo=" + activo +
                '}';
    }
}