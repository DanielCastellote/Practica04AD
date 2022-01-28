package mapper;

import dao.Departamento;
import dao.Login;
import dto.DepartamentoDTO;
import dto.LoginDTO;

public class LoginMapper extends BaseMapper<Login, LoginDTO>{

    @Override
    public Login fromDTO(LoginDTO item) {
        Login login = new Login();
        if (item.getId() != null) {
            login.setId(item.getId());
        }
        login.setInstSalida(item.getInstIdentificacion());
        login.setToken(item.getToken());
        login.setActivo(item.isActivo());
        return login;
    }
    @Override
    public LoginDTO toDTO(Login item) {
        return LoginDTO.builder()
                .id(item.getId())
                .instIdentificacion(item.getInstSalida())
                .token(item.getToken())
                .activo(item.isActivo())
                .build();
    }
}
