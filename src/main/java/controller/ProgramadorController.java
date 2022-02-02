package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.ProgramadorDTO;
import repository.ProgramadorRepository;
import service.ProgramadorService;

import java.sql.SQLException;
import java.util.List;

public class ProgramadorController {
    private static ProgramadorController controller = null;

    private final ProgramadorService programadorService;

    private ProgramadorController(ProgramadorService programadorService) {
        this.programadorService = programadorService;
    }

    public static ProgramadorController getInstance() {
        if (controller == null) {
            controller = new ProgramadorController(new ProgramadorService(new ProgramadorRepository()));
        }
        return controller;
    }

    public List<ProgramadorDTO> getAllProgramadores() {
        try {
            return programadorService.getAllProgramador();
        } catch (SQLException e) {
            System.err.println("Error ProgramadorController en getAllProgramador: " + e.getMessage());
            return null;
        }
    }
    public String getAllProgramadorJSON() {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(programadorService.getAllProgramador());
        } catch (SQLException e) {
            System.err.println("Error ProgramadorController en getAllProgramador: " + e.getMessage());
            return "Error ProgramadorController en getAllProgramador: " + e.getMessage();
        }
    }
    public String getProgramadorByIdJSON(Long id) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(programadorService.getProgramadorById(id));
        } catch (SQLException e) {
            System.err.println("Error ProgramadorController en getProgramadorById: " + e.getMessage());
            return "Error ProgramadorController en getProgramadorById: " + e.getMessage();
        }
    }

    public ProgramadorDTO getProgramadorById(Long id) {
        try {
            return programadorService.getProgramadorById(id);
        } catch (SQLException e) {
            System.err.println("Error ProgramadorController en getProgramadorById " + e.getMessage());
            return null;
        }
    }

    public ProgramadorDTO postProgramador(ProgramadorDTO programadorDTO) {
        try {
            return programadorService.postProgramador(programadorDTO);
        } catch (SQLException e) {
            System.err.println("Error ProgramadorController en postProgramador " + e.getMessage());
            return null;
        }
    }

    public ProgramadorDTO updateProgramador(ProgramadorDTO programadorDTO) {
        try {
            return programadorService.updateProgramador(programadorDTO);
        } catch (SQLException e) {
            System.err.println("Error ProgramadorController en updateProgramador " + e.getMessage());
            return null;
        }
    }

    public ProgramadorDTO deleteProgramador(ProgramadorDTO programadorDTO) {
        try {
            return programadorService.deleteProgramador(programadorDTO);
        } catch (SQLException e) {
            System.err.println("Error ProgramadorController en deleteProgramador " + e.getMessage());
            return null;
        }
    }

}
