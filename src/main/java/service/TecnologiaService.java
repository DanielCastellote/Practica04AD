package service;


import dao.Repositorio;
import dao.Tecnologia;
import dto.RepositorioDTO;
import dto.TecnologiaDTO;
import mapper.RepositorioMapper;
import mapper.TecnologiaMapper;
import repository.RepositorioRepository;
import repository.TecnologiaRepository;

import java.sql.SQLException;
import java.util.List;


public class TecnologiaService extends BaseService<Tecnologia, Long, TecnologiaRepository> {

    public TecnologiaService(TecnologiaRepository repository) {
        super(repository);
    }
    TecnologiaMapper mapper = new TecnologiaMapper();

    public List<TecnologiaDTO> getAllTecnologias() throws SQLException {
        return mapper.toDTO(this.findAll());
    }

    public TecnologiaDTO getTecnologiaById(Long id) throws SQLException {
        return mapper.toDTO(this.getById(id));
    }

    public TecnologiaDTO postTecnologia(TecnologiaDTO tecnologiaDTO) throws SQLException {

        Tecnologia tecno = this.save(mapper.fromDTO(tecnologiaDTO));
        return mapper.toDTO(tecno);
    }

    public TecnologiaDTO updateTecnologia(TecnologiaDTO tecnologiaDTO) throws SQLException {
        Tecnologia tecno = this.update(mapper.fromDTO(tecnologiaDTO));
        return mapper.toDTO(tecno);
    }

    public TecnologiaDTO deleteTecnologia(TecnologiaDTO tecnologiaDTO) throws SQLException {
        Tecnologia tecno = this.delete(mapper.fromDTO(tecnologiaDTO));
        return mapper.toDTO(tecno);
    }
}