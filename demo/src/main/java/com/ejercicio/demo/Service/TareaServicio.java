package com.ejercicio.demo.Service;

import com.ejercicio.demo.Dto.DtoTarea;
import com.ejercicio.demo.Exception.ServiceException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TareaServicio {

    public DtoTarea crearTarea (DtoTarea dtoTarea) throws ServiceException;
    public List<DtoTarea> obtenerTareas();

    public DtoTarea actualizarTarea(DtoTarea dtoTarea, Long id) throws ServiceException;

    public void eliminarTarea(Long id) throws ServiceException;
}
