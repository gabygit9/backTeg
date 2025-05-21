package ar.edu.utn.frc.tup.piii.controllers;




//TODO agregar manejo de excepciones y respuestas HTTP más detalladas
//TODO usar responseEntity<?> en la firma de todos los métodos

import ar.edu.utn.frc.tup.piii.model.entities.Continente;
import ar.edu.utn.frc.tup.piii.services.ContinenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador REST para gestionar los continentes.
 * Ofrece endpoints para consultar la lista de continentes disponibles.
 *
 * @author GabrielaCamacho
 */
@RestController
@RequestMapping("/api/v1/continentes")
@RequiredArgsConstructor
public class ContinenteController {
    private final ContinenteService continenteService;

    /**
     * Obtiene todos los continentes disponibles.
     *
     * @return lista de continentes
     */
    @GetMapping
    public List<Continente> obtenerTodos() {
        return continenteService.obtenerTodos();
    }

    /**
     * Obtiene un continente por su ID.
     *
     * @param id identificador del continente
     * @return el continente correspondiente o null si no se encuentra
     */
    @GetMapping("/{id}")
    public Continente obtenerPorId(@PathVariable int id) {
        return continenteService.obtenerPorId(id);
    }
}
