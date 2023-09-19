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
        Pedido pedidoSave = pedidoRepository.save(new Pedido("Saco1",12));
        assertThat(pedidoSave.getId()).isGreaterThan(0);
    }

    @Test
    public void testFindProductByName(){
        Pedido pedidoSave = pedidoRepository.save(new Pedido("Saco",12));
        assertThat(pedidoSave.getName()).isEqualTo("Saco");
    }

    @Test
    @Rollback(false)
    public void testUpdateProduct() {
        pedidoRepository.save(new Pedido("Saco11",12));
        Pedido product = pedidoRepository.findByName("Saco11");
        product.setQuantidade(1000);

        pedidoRepository.save(product);

        Pedido updatedPedido = pedidoRepository.findByName("Saco11");

        assertThat(updatedPedido.getQuantidade()).isEqualTo(1000);
    }


//https://www.codejava.net/frameworks/spring-boot/junit-tests-for-spring-data-jpa

}
