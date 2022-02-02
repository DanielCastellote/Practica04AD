package dto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.Programador;
import dao.Repositorio;
import lombok.Builder;
import lombok.Data;


import java.util.Date;

@Data
@Builder
public class CommitDTO {

    private Long id;
    private String titulo;
    private String texto;
    private Date fCreacion;

    @Override
    public String toString() {
        return "CommitDTO{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", texto='" + texto + '\'' +
                ", fCreacion=" + fCreacion +
                '}';
    }
}