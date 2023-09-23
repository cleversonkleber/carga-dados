package br.com.cargadados.dto;

import br.com.cargadados.model.Pedido;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RequisicaoNovoPedido {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    private Integer quantidade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Pedido toPedido(){
        Pedido pedido = new Pedido();
        pedido.setName(this.name);
        pedido.setQuantidade(this.quantidade);
         return pedido;
    }

    @Override
    public String toString() {
        return "RequisicaoNovoPedido{" +
                "name='" + name + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
}
