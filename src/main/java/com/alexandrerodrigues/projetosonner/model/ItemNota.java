package com.alexandrerodrigues.projetosonner.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class ItemNota implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="id_nota")
    private Nota nota;

    @ManyToOne
    @JoinColumn(name="id_produto")
    private Produto produto;
    private BigDecimal valorTotal;

    public ItemNota() {
        super();
    }
    public ItemNota(Integer id, Produto produto, Nota nota, BigDecimal valorTotal) {
        super();
        this.id = id;
        this.nota = nota;
        this.produto = produto;
        this.valorTotal = valorTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getValorTotal() { return valorTotal; }

    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }

}