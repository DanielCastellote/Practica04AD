package service;

import dao.Departamento;
import dto.DepartamentoDTO;
import mapper.DepartamentoMapper;
import repository.DepartamentoRepository;
import java.sql.SQLException;
import java.util.List;

public class DepartamentoService extends BaseService<Departamento, Long, DepartamentoRepository> {

    DepartamentoMapper mapper = new DepartamentoMapper();


    public DepartamentoService(DepartamentoRepository repository) {
        super(repository);
    }

    public List<DepartamentoDTO> getAllDepartamento() throws SQLException {
        return mapper.toDTO(this.findAll());
    }

    public DepartamentoDTO getDepartamentoById(Long id) throws SQLException {
        return mapper.toDTO(this.getById(id));
    }

    public DepartamentoDTO postDepartamento(DepartamentoDTO departamentoDTO) throws SQLException {

        Departamento dept = this.save(mapper.fromDTO(departamentoDTO));
        return mapper.toDTO(dept);
    }

    public DepartamentoDTO updateDepartamento(DepartamentoDTO departamentoDTO) throws SQLException {
        Departamento dept = this.update(mapper.fromDTO(departamentoDTO));
        return mapper.toDTO(dept);
    }

    public DepartamentoDTO deleteDepartamento(DepartamentoDTO departamentoDTO) throws SQLException {
        Departamento dept = this.delete(mapper.fromDTO(departamentoDTO));
        return mapper.toDTO(dept);
    }
}
