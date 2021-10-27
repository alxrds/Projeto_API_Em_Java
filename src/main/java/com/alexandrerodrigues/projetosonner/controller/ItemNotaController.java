package com.alexandrerodrigues.projetosonner.controller;

import com.alexandrerodrigues.projetosonner.model.ItemNota;

import com.alexandrerodrigues.projetosonner.model.Produto;
import com.alexandrerodrigues.projetosonner.repository.ItemNotaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/itens")
public class ItemNotaController {

    private Produto produto;

    private ItemNotaRepository itemNotaRepository;

    public ItemNotaController(ItemNotaRepository itemNotaRepository) {
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
        List<ItemNota> itensNota = new ArrayList<>();
        itensNota = itemNotaRepository.findAll();
        return new ResponseEntity<>(itensNota, HttpStatus.OK);
    }

}
