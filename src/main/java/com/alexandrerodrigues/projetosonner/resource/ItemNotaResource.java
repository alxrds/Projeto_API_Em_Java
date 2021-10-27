package com.alexandrerodrigues.projetosonner.resource;

import com.alexandrerodrigues.projetosonner.model.ItemNota;
import com.alexandrerodrigues.projetosonner.model.Nota;
import com.alexandrerodrigues.projetosonner.repository.ItemNotaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/itens")
public class ItemNotaResource {

    private ItemNotaRepository itemNotaRepository;

    public ItemNotaResource(ItemNotaRepository itemNotaRepository) {
        super();
        this.itemNotaRepository = itemNotaRepository;
    }

    @PostMapping
    public ResponseEntity<ItemNota> save(@RequestBody ItemNota itemNota) {
        itemNotaRepository.save(itemNota);
        return new ResponseEntity<>(itemNota, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ItemNota>> getAll() {
        List<ItemNota> itemNotas = new ArrayList<>();
        itemNotas = itemNotaRepository.findAll();
        return new ResponseEntity<>(itemNotas, HttpStatus.OK);
    }


}
