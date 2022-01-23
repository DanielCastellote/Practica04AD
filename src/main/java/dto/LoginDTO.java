package dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class LoginDTO {

    private long id;
    private Timestamp instIdentificacion;
    private long token;
    private boolean activo;

    @Override
    public String toString() {
        return "LoginDTO{" +
                "id=" + id +
                ", instIdentificacion=" + instIdentificacion +
                ", token=" + token +
                ", activo=" + activo +
                '}';
    }
}
