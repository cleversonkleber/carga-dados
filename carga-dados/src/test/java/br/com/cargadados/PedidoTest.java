package br.com.cargadados;


import br.com.cargadados.model.Pedido;
import br.com.cargadados.repository.PedidoRepository;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PedidoTest {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Test
    @Rollback(false)
    public void testCreatePedido(){
        Pedido pedidoSave = pedidoRepository.save(new Pedido("Saco",12));
        assertThat(pedidoSave.getId()).isGreaterThan(0);
    }

    @Test
    public void testFindProductByName(){
        Pedido pedidoSave = pedidoRepository.save(new Pedido("Saco",12));
        assertThat(pedidoSave.getProduto()).isEqualTo("Saco");
    }

//    @Test
//    public void testUpdateProduct() {
//        Pedido product = pedidoRepository.findByName("Saco");
//        product.setQuantidade(1000);
//
//        pedidoRepository.save(product);
//
//        Pedido updatedPedido = pedidoRepository.findByName("Saco");
//
//        assertThat(updatedPedido.getQuantidade()).isEqualTo(1000);
//    }


//https://www.codejava.net/frameworks/spring-boot/junit-tests-for-spring-data-jpa

}
