package com.alexandrerodrigues.projetosonner.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Nota implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numero;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataNota;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @JsonIgnore
    @OneToMany(mappedBy = "nota")
    private List<ItemNota> items;

    public Nota() {
        super();
        this.setDataNota(LocalDateTime.now());

    }

    public Nota(Integer id, Integer numero, LocalDateTime dataNota, Cliente cliente, List<ItemNota> items) {
        this.id = id;
        this.numero = numero;
        this.setDataNota(LocalDateTime.now());
        this.cliente = cliente;
        this.items = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public LocalDateTime getDataNota() {
        return dataNota;
    }

    public void setDataNota(LocalDateTime dataNota) {
        this.dataNota = dataNota;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemNota> getItems() {
        return items;
    }

    public void setItems(List<ItemNota> items) {
        this.items = items;
    }
}