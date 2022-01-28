package service;

import dao.Proyecto;
import dto.ProyectoDTO;
import mapper.ProyectoMapper;
import repository.ProyectoRepository;

import java.sql.SQLException;
import java.util.List;

public class ProyectoService extends BaseService<Proyecto, Long, ProyectoRepository>{

    ProyectoMapper mapper = new ProyectoMapper();


    public ProyectoService(ProyectoRepository repository) {
        super(repository);
    }

    public List<ProyectoDTO> getAllProyecto() throws SQLException {
        return mapper.toDTO(this.findAll());
    }

    public ProyectoDTO getProyectoById(Long id) throws SQLException {
        return mapper.toDTO(this.getById(id));
    }

    public ProyectoDTO postProyecto(ProyectoDTO proyectoDTO) throws SQLException {

        Proyecto proy = this.save(mapper.fromDTO(proyectoDTO));
        return mapper.toDTO(proy);
    }

    public ProyectoDTO updateProyecto(ProyectoDTO proyectoDTO) throws SQLException {
        Proyecto proy = this.update(mapper.fromDTO(proyectoDTO));
        return mapper.toDTO(proy);
    }

    public ProyectoDTO deleteProyecto(ProyectoDTO proyectoDTO) throws SQLException {
        Proyecto proy = this.delete(mapper.fromDTO(proyectoDTO));
        return mapper.toDTO(proy);
    }
}
