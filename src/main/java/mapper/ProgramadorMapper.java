package mapper;

import dao.Programador;
import dto.ProgramadorDTO;

public class ProgramadorMapper extends BaseMapper<Programador, ProgramadorDTO>{

    @Override
    public Programador fromDTO(ProgramadorDTO item) {
        Programador programador = new Programador();
        if (item.getId() != null) {
            programador.setId(item.getId());
        }
        programador.setNombre(item.getNombre());
        programador.setfAlta(item.getFAlta());
        programador.setSalario(item.getSalario());
        programador.setEmail(item.getEmail());
        programador.setContrasena(item.getContrasena());

        return programador;
    }

    @Override
    public ProgramadorDTO toDTO(Programador item) {
        return ProgramadorDTO.builder()
                .id(item.getId())
                .nombre(item.getNombre())
                .fAlta(item.getfAlta())
                .salario(item.getSalario())
                .email(item.getEmail())
                .contrasena(item.getContrasena())
                .build();
    }
}
