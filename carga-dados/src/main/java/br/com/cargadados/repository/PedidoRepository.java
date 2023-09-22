package br.com.cargadados.repository;

import br.com.cargadados.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

   public Pedido findByName(String name);
}


