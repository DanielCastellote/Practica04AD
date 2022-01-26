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
        login.setActivo(item.isActivo());
        login.setProgramador(item.getProgramador());
        login.setToken(item.getToken());
        return login;
    }
    @Override
    public LoginDTO toDTO(Login item) {
        return LoginDTO.builder()
                .id(item.getId())
                .instIdentificacion(item.getInstSalida())
                .activo(item.isActivo())
                .token(item.getToken())
                .programador(item.getProgramador())
                .build();
    }
}
