package mapper;

import dao.Departamento;
import dao.Proyecto;
import dto.DepartamentoDTO;
import dto.ProyectoDTO;

public class ProyectoMapper extends BaseMapper<Proyecto, ProyectoDTO> {

    @Override
    public Proyecto fromDTO(ProyectoDTO item) {
        Proyecto proyecto = new Proyecto();
        if (item.getId() != null) {
            proyecto.setId(item.getId());
        }
        proyecto.setNombre(item.getNombre());
        proyecto.setPresupuesto(item.getPresupuesto());
        proyecto.setfInicio(item.getFInicio());
        proyecto.setfFin(item.getFFin());
        proyecto.setProgramadores(item.getProgramadores());
        proyecto.setDepartamento(item.getDepartamento());
        return proyecto;
    }
    @Override
    public ProyectoDTO toDTO(Proyecto item) {
        return ProyectoDTO.builder()
                .id(item.getId())
                .nombre(item.getNombre())
                .presupuesto(item.getPresupuesto())
                .fInicio(item.getfInicio())
                .fFin(item.getfFin())
                .programadores(item.getProgramadores())
                .departamento(item.getDepartamento())
                .build();
    }
}
