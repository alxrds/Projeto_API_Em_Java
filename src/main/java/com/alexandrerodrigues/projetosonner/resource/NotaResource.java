package com.alexandrerodrigues.projetosonner.resource;

import com.alexandrerodrigues.projetosonner.model.Nota;
import com.alexandrerodrigues.projetosonner.repository.NotaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/notas")
public class NotaResource {

    private NotaRepository notaRepository;

    public NotaResource(NotaRepository notaRepository) {
        super();
        this.notaRepository = notaRepository;
    }

    @PostMapping
    public ResponseEntity<Nota> save(@RequestBody Nota nota) {
        notaRepository.save(nota);
        return new ResponseEntity<>(nota, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Nota>> getAll() {
        List<Nota> notas = new ArrayList<>();
        notas = notaRepository.findAll();
        return new ResponseEntity<>(notas, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Nota>> getById(@PathVariable Integer id) {
        Optional<Nota> nota;
        try {
            nota = notaRepository.findById(id);
            return new ResponseEntity<Optional<Nota>>(nota, HttpStatus.OK);
        }catch (NoSuchElementException nsee) {
            return new ResponseEntity<Optional<Nota>>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
        public ResponseEntity<Optional<Nota>> deleteById(@PathVariable Integer id) {
        try {
            notaRepository.deleteById(id);
            return new ResponseEntity<Optional<Nota>>(HttpStatus.OK);
        } catch (NoSuchElementException nsee) {
            return new ResponseEntity<Optional<Nota>>(HttpStatus.NOT_FOUND);
        }
    }

}
