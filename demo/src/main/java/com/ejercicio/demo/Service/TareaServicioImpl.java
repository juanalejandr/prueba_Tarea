package com.ejercicio.demo.Service;

import com.ejercicio.demo.Dto.DtoTarea;
import com.ejercicio.demo.Entity.Tarea;
import com.ejercicio.demo.Exception.ServiceException;
import com.ejercicio.demo.Repository.TareaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TareaServicioImpl implements TareaServicio {

    @Autowired
    private TareaRepositorio tareaRepositorio;
    String mensaje=null;

    private DtoTarea mapearDto (Tarea tarea){
        DtoTarea dtoTarea= new DtoTarea();
        dtoTarea.setId(tarea.getId());
        dtoTarea.setDescripcion(tarea.getDescripcion());
        dtoTarea.setFechaCreacion(tarea.getFechaCreacion());
        return dtoTarea;
    }
    private Tarea mapearEntidad(DtoTarea dtoTarea){
        Tarea tarea= new Tarea();
        tarea.setDescripcion(dtoTarea.getDescripcion());
        tarea.setFechaCreacion(dtoTarea.getFechaCreacion());
        tarea.setVigente(dtoTarea.getVigente());
        return tarea;
    }

    @Override
    public DtoTarea crearTarea(DtoTarea dtoTarea) throws ServiceException {
        try{Tarea tarea = mapearEntidad(dtoTarea);
            Tarea crearTarea= tareaRepositorio.save(tarea);
            DtoTarea TareaRespuesta= mapearDto(crearTarea);
            return TareaRespuesta;}
        catch (Exception e){
            mensaje= " datos obligatorios incompletos";
            throw new ServiceException(mensaje);
        }
    }


    @Override
    public List<DtoTarea> obtenerTareas() {
        List <Tarea> tareas= tareaRepositorio.findAll();
        return tareas.stream().map(tarea -> mapearDto(tarea)).collect(Collectors.toList());
    }

    @Override
    public DtoTarea actualizarTarea(DtoTarea dtoTarea, Long id) throws ServiceException {
        mensaje= "id no encontrado";
            Tarea tarea = tareaRepositorio.findById(id).orElseThrow(() ->new ServiceException(mensaje));
            tarea.setId(dtoTarea.getId());
            tarea.setDescripcion(dtoTarea.getDescripcion());
            tarea.setFechaCreacion(dtoTarea.getFechaCreacion());
            tarea.setVigente(tarea.getVigente());
            Tarea tareaActualizada= tareaRepositorio.save(tarea);
            return mapearDto(tareaActualizada);

    }

    @Override
    public void eliminarTarea(Long id)throws ServiceException {
        mensaje= "id no encontrado";
        Tarea tarea = tareaRepositorio.findById(id).orElseThrow(() -> new ServiceException(mensaje));
        tareaRepositorio.delete(tarea);
    }
}
