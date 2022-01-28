package service;

import dao.Repositorio;
import dto.RepositorioDTO;
import mapper.RepositorioMapper;
import repository.RepositorioRepository;

import java.sql.SQLException;
import java.util.List;

public class RepositorioService extends BaseService<Repositorio, Long, RepositorioRepository>{

    RepositorioMapper mapper = new RepositorioMapper();


    public RepositorioService(RepositorioRepository repository) {
        super(repository);
    }

    public List<RepositorioDTO> getAllRepositorio() throws SQLException {
        return mapper.toDTO(this.findAll());
    }

    public RepositorioDTO getRepositorioById(Long id) throws SQLException {
        return mapper.toDTO(this.getById(id));
    }

    public RepositorioDTO postRepositorio(RepositorioDTO repositorioDTO) throws SQLException {

        Repositorio repo = this.save(mapper.fromDTO(repositorioDTO));
        return mapper.toDTO(repo);
    }

    public RepositorioDTO updateRepositorio(RepositorioDTO repositorioDTO) throws SQLException {
        Repositorio repo = this.update(mapper.fromDTO(repositorioDTO));
        return mapper.toDTO(repo);
    }

    public RepositorioDTO deleteRepositorio(RepositorioDTO repositorioDTO) throws SQLException {
        Repositorio repo = this.delete(mapper.fromDTO(repositorioDTO));
        return mapper.toDTO(repo);
    }
}
