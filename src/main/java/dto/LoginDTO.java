package dto;

import dao.Programador;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class LoginDTO {

    private Long id;
    private Timestamp instIdentificacion;
    private String token;
    private boolean activo;
    private Programador programador;

    @Override
    public String toString() {
        return "LoginDTO{" +
                "id=" + id +
                ", instIdentificacion=" + instIdentificacion +
                ", token=" + token +
                ", activo=" + activo +
                ", programador=" + programador +
                '}';
    }
}