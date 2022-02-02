package service;

import dao.Login;
import dao.Programador;
import dto.LoginDTO;
import mapper.LoginMapper;
import repository.LoginRepository;
import repository.ProgramadorRepository;
import utils.Cifrador;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

public class LoginService extends BaseService<Login, Long, LoginRepository>{

    LoginMapper mapper = new LoginMapper();

    public LoginService(LoginRepository repository) {
        super(repository);
    }

    public Optional<List<Login>> getAllLogins() throws SQLException {
        return null;
    }

    public LoginDTO login(String email, String contrasena) throws SQLException {
        try {
            Programador programador = getProgramadorByMail(email);
            Cifrador cif = Cifrador.getInstance();
            if ((programador != null) && programador.getContrasena().equals(cif.SHA256(contrasena))) {
                Login insert = new Login();
                insert.setId(programador.getId());
                insert.setInstSalida(Timestamp.from(Instant.now()));
                LoginDTO login = mapper.toDTO(repository.save(insert));
                return login;
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    private Programador getProgramadorByMail(String email) throws SQLException {
        ProgramadorService service = new ProgramadorService(new ProgramadorRepository());
        return service.getProgramadorByMail(email);
    }

    public boolean logout(Long programadorId) throws SQLException {
        return repository.deleteByProgramadorId(programadorId);
    }
}
