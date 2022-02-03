package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.ProgramadorDTO;
import dto.ProyectoDTO;
import repository.ProyectoRepository;
import service.ProyectoService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProyectoController {
        private static ProyectoController controller = null;

        private final ProyectoService proyectoService;

        private ProyectoController(ProyectoService proyectoService) {
            this.proyectoService = proyectoService;
        }

        public static ProyectoController getInstance() {
            if (controller == null) {
                controller = new ProyectoController(new ProyectoService(new ProyectoRepository()));
            }
            return controller;
        }

        public List<ProyectoDTO> getAllProyectos() {
            try {
                return proyectoService.getAllProyecto();
            } catch (SQLException e) {
                System.err.println("Error ProyectoController en getAllProyecto: " + e.getMessage());
                return null;
            }
        }
    public String getAllProyectoJSON() {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(proyectoService.getAllProyecto());
        } catch (SQLException e) {
            System.err.println("Error ProyectoController en getAllProyecto: " + e.getMessage());
            return "Error ProyectoController en getAllProyecto: " + e.getMessage();
        }
    }
    public String getProyectoByIdJSON(Long id) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(proyectoService.getProyectoById(id));
        } catch (SQLException e) {
            System.err.println("Error ProyectoController en getProyectoById: " + e.getMessage());
            return "Error ProyectoController en getProyectoById: " + e.getMessage();
        }
    }

        public ProyectoDTO getProyectoById(Long id) {
            try {
                return proyectoService.getProyectoById(id);
            } catch (SQLException e) {
                System.err.println("Error ProyectoController en getProyectoById " + e.getMessage());
                return null;
            }
        }

        public ProyectoDTO postProyecto(ProyectoDTO proyectoDTO) {
            try {
                return proyectoService.postProyecto(proyectoDTO);
            } catch (SQLException e) {
                System.err.println("Error ProyectoController en postProyecto " + e.getMessage());
                return null;
            }
        }

        public ProyectoDTO updateProyecto(ProyectoDTO proyectoDTO) {
            try {
                return proyectoService.updateProyecto(proyectoDTO);
            } catch (SQLException e) {
                System.err.println("Error ProyectoController en updateProyecto " + e.getMessage());
                return null;
            }
        }

        public ProyectoDTO deleteProyecto(ProyectoDTO proyectoDTO) {
            try {
                return proyectoService.deleteProyecto(proyectoDTO);
            } catch (SQLException e) {
                System.err.println("Error ProyectoController en deleteProyecto " + e.getMessage());
                return null;
            }
        }

    public Optional<ProyectoDTO> getProyectoByIdOptional(Long id) {
        try {
            return Optional.of(proyectoService.getProyectoById(id));
        } catch (SQLException e) {
            System.err.println("Error ProyectoController en getProyectoById: " + e.getMessage());
            return Optional.empty();
        }
    }
}