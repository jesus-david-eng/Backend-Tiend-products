package co.com.sofka.products;


import co.com.sofka.products.product.Product;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestEntity {
    Product product;

    @Before
    public void inicializador() {
        this.product = new Product("01", "Jose", "7:00", "fecha", "Cartagena", "Medellin");
    }

    @Test
    public void setterAndGetterTest() {
        Assertions.assertThat(this.product.getId()).isEqualTo("01");
        Assertions.assertThat(this.product.getId()).isEqualTo("01");
        Assertions.assertThat(this.product.getName()).isEqualTo("Jose");
        Assertions.assertThat(this.product.getDescription()).isEqualTo("7:00");
        Assertions.assertThat(this.product.getUrlLogo()).isEqualTo("fecha");
        Assertions.assertThat(this.product.getPrice()).isEqualTo("Cartagena");
        Assertions.assertThat(this.product.getMarca()).isEqualTo("Medellin");
    }
}
