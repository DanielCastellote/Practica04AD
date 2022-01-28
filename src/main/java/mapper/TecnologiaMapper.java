package mapper;

import dao.Commit;
import dao.Tecnologia;
import dto.CommitDTO;
import dto.TecnologiaDTO;

public class TecnologiaMapper extends BaseMapper<Tecnologia, TecnologiaDTO> {
    @Override
    public Tecnologia fromDTO(TecnologiaDTO item) {
        Tecnologia tecnologia = new Tecnologia();
        if (item.getId() != null) {
            tecnologia.setId(item.getId());
        }
        tecnologia.setNombre(item.getNombre());
        tecnologia.setProgramador(item.getProgramador());
        return tecnologia;
    }

    @Override
    public TecnologiaDTO toDTO(Tecnologia item) {
        return TecnologiaDTO.builder()
                .id(item.getId())
                .nombre(item.getNombre())
                .programador(item.getProgramador())
                .build();
    }
}