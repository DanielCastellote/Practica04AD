package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.DepartamentoDTO;
import repository.DepartamentoRepository;
import service.DepartamentoService;

import java.sql.SQLException;
import java.util.List;

public class DepartamentoController {
    private static DepartamentoController controller = null;

    private final DepartamentoService departamentoService;

    private DepartamentoController(DepartamentoService programadorService) {
        this.departamentoService = programadorService;
    }

    public static DepartamentoController getInstance() {
        if (controller == null) {
            controller = new DepartamentoController(new DepartamentoService(new DepartamentoRepository()));
        }
        return controller;
    }

    public List<DepartamentoDTO> getAllDepartamento() {
        try {
            return departamentoService.getAllDepartamento();
        } catch (SQLException e) {
            System.err.println("Error DepartamentoController en getAllDepartamento: " + e.getMessage());
            return null;
        }
    }
    public String getAllDepartamentoJSON() {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(departamentoService.getAllDepartamento());
        } catch (SQLException e) {
            System.err.println("Error DepartamentoController en getAll: " + e.getMessage());
            return "Error DepartamentoController en getAll: " + e.getMessage();
        }
    }

    public DepartamentoDTO getDepartamentoById(Long id) {
        try {
            return departamentoService.getDepartamentoById(id);
        } catch (SQLException e) {
            System.err.println("Error DepartamentoController en getDepartamentoById " + e.getMessage());
            return null;
        }
    }

    public DepartamentoDTO postDepartamento(DepartamentoDTO departamentoDTO) {
        try {
            return departamentoService.postDepartamento(departamentoDTO);
        } catch (SQLException e) {
            System.err.println("Error DepartamentoController en postDepartamento " + e.getMessage());
            return null;
        }
    }

    public DepartamentoDTO updateDepartamento(DepartamentoDTO departamentoDTO) {
        try {
            return departamentoService.updateDepartamento(departamentoDTO);
        } catch (SQLException e) {
            System.err.println("Error DepartamentoController en updateDepartamento " + e.getMessage());
            return null;
        }
    }

    public DepartamentoDTO deleteDepartamento(DepartamentoDTO departamentoDTO) {
        try {
            return departamentoService.deleteDepartamento(departamentoDTO);
        } catch (SQLException e) {
            System.err.println("Error DepartamentoController en deleteDepartamento " + e.getMessage());
            return null;
        }
    }
}
