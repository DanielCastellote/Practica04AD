package mapper;

import dao.Departamento;
import dao.Programador;
import dto.DepartamentoDTO;
import dto.ProgramadorDTO;

public class DepartamentoMapper extends BaseMapper<Departamento, DepartamentoDTO>{

    @Override
    public Departamento fromDTO(DepartamentoDTO item) {
        Departamento departamento = new Departamento();
        if (item.getId() != null) {
            departamento.setId(item.getId());
        }
        departamento.setNombre(item.getNombre());
        departamento.setPresupuesto(item.getPresupuesto());
        departamento.setPresupuestoAnual(item.getPresupuestoAnual());
        departamento.setProgramadores(item.getProgramadores());
        departamento.setProyectos(item.getProyectos());
        return departamento;
    }
    @Override
    public DepartamentoDTO toDTO(Departamento item) {
        return DepartamentoDTO.builder()
                .id(item.getId())
                .nombre(item.getNombre())
                .presupuesto(item.getPresupuesto())
                .presupuestoAnual(item.getPresupuestoAnual())
                .programadores(item.getProgramadores())
                .proyectos(item.getProyectos())
                .build();
    }
}
