package com.ejercicio.demo.Repository;

import com.ejercicio.demo.Entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepositorio extends JpaRepository <Tarea, Long> {
}
