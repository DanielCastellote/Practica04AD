package dto;

import dao.Commit;
import dao.Login;
import dao.Tecnologia;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Builder
@Data
public class ProgramadorDTO {

    private Long id;
    private String nombre;
    private Date fAlta;
    private double salario;
    private String email;
    private String contrasena;
    private Set<Tecnologia> lenguajes = new HashSet<>();
    private Set<Commit> commits;
    private Login login= new Login();

    @Override
    public String toString() {
        return "ProgramadorDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fAlta=" + fAlta +
                ", salario=" + salario +
                ", email='" + email + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }
}
