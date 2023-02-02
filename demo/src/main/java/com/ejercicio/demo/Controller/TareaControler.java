package com.ejercicio.demo.Controller;

import com.ejercicio.demo.Dto.DtoTarea;
import com.ejercicio.demo.Exception.ServiceException;
import com.ejercicio.demo.Service.TareaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Tarea")
public class TareaControler {
    @Autowired
    private TareaServicio tareaServicio;

    @PostMapping
    public ResponseEntity <DtoTarea> guardarTarea(@RequestBody DtoTarea dtoTarea) throws ServiceException {
        return new ResponseEntity<>(tareaServicio.crearTarea(dtoTarea), HttpStatus.CREATED);
    }

    @GetMapping
    public List <DtoTarea> listarTareas (){
        return tareaServicio.obtenerTareas();
    }

    @PutMapping("/{id}")
    public ResponseEntity <DtoTarea> actualizarTarea(@RequestBody DtoTarea dtoTarea, @PathVariable (name = "id")Long id) throws ServiceException {
        DtoTarea tareaRespuesta= tareaServicio.actualizarTarea(dtoTarea, id);
        return new ResponseEntity<>(tareaRespuesta, HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity <String> eiminarTarea (@PathVariable(name = "id")Long id) throws ServiceException {
        tareaServicio.eliminarTarea(id);
        return new ResponseEntity<>("tarea eliminada", HttpStatus.OK);
    }
}
