package controller;

import dto.ProgramadorDTO;
import dto.ProyectoDTO;
import repository.ProgramadorRepository;
import repository.ProyectoRepository;
import service.ProgramadorService;
import service.ProyectoService;

import java.sql.SQLException;
import java.util.List;

public class ProyectoController {
        private static controller.ProyectoController controller = null;

        private final ProyectoService proyectoService;

        private ProyectoController(ProyectoService proyectoService) {
            this.proyectoService = proyectoService;
        }

        public static controller.ProyectoController getInstance() {
            if (controller == null) {
                controller = new controller.ProyectoController(new ProyectoService(new ProyectoRepository()));
            }
            return controller;
        }

        public List<ProyectoDTO> getAllProyectos() {
            try {
                return proyectoService.getAllProyectos();
            } catch (SQLException e) {
                System.err.println("Error ProyectoController en getAllProyecto: " + e.getMessage());
                return null;
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
                return proyectoService.updateProyecto(ProyectoDTO);
            } catch (SQLException e) {
                System.err.println("Error ProyectoController en updateProyecto " + e.getMessage());
                return null;
            }
        }

        public ProyectoDTO deleteProyecto(ProgramadorDTO ProyectoDTO) {
            try {
                return proyectoService.deleteProyecto(proyectoDTO);
            } catch (SQLException e) {
                System.err.println("Error ProyectoController en deleteProyecto " + e.getMessage());
                return null;
            }
        }

    }