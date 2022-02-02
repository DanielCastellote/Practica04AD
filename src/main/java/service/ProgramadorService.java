package service;

import dao.Programador;
import dto.ProgramadorDTO;
import mapper.ProgramadorMapper;
import repository.ProgramadorRepository;
import utils.Cifrador;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class ProgramadorService extends BaseService<Programador, Long, ProgramadorRepository> {

    ProgramadorMapper mapper = new ProgramadorMapper();


    public ProgramadorService(ProgramadorRepository repository) {
        super(repository);
    }

    public List<ProgramadorDTO> getAllProgramador() throws SQLException {
        return mapper.toDTO(this.findAll());
    }

    public ProgramadorDTO getProgramadorById(Long id) throws SQLException {
        return mapper.toDTO(this.getById(id));
    }

    public ProgramadorDTO postProgramador(ProgramadorDTO programadorDTO) throws SQLException {
        // Ciframos antes el password
        programadorDTO.setContrasena(Cifrador.getInstance().SHA256(programadorDTO.getContrasena()));
        // Le ponemos la fecha de registro
        programadorDTO.setFAlta(new Date(System.currentTimeMillis()));
        Programador prog = this.save(mapper.fromDTO(programadorDTO));
        return mapper.toDTO(prog);
    }

    public ProgramadorDTO updateProgramador(ProgramadorDTO programadorDTO) throws SQLException {
        Programador prog = this.update(mapper.fromDTO(programadorDTO));
        return mapper.toDTO(prog);
    }

    public ProgramadorDTO deleteProgramador(ProgramadorDTO programadorDTO) throws SQLException {
        Programador prog = this.delete(mapper.fromDTO(programadorDTO));
        return mapper.toDTO(prog);
    }

    public Programador getProgramadorByMail(String email) throws SQLException {
        return repository.getByEmail(email);
    }


}
