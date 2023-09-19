package br.com.cargadados.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="tb_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(name="nome_produto", length=50, nullable=false)
    private String produto;

    private Integer quantidade;

    public Pedido() {
    }

    public Pedido(String produto, Integer quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id) && Objects.equals(produto, pedido.produto) && Objects.equals(quantidade, pedido.quantidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, produto, quantidade);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", produto='" + produto + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }


}
