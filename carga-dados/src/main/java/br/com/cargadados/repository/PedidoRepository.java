package br.com.cargadados.repository;

import br.com.cargadados.model.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {

//    public Pedido findByName(String produto);
}
