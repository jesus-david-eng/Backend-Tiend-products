package co.com.sofka.products;

import co.com.sofka.products.product.Product;
import co.com.sofka.products.product.ProductFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@RunWith(MockitoJUnitRunner.class)
public class TestProductsFactory {

    private Product product;

    @Before
    public void setUp() {
        product = new Product("3", "Samsumg s6", "ultra camara", "www.google.com", "23.900", "Ipad");
    }

    @Test
    public void ProductTest(){
        Product producto = product.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .urlLogo(product.getUrlLogo())
                .price(product.getPrice())
                .marca(product.getMarca())
                .build();

        Mono<Product> products = ProductFactory.create(product.getId(), product.getName(), product.getDescription(), product.getUrlLogo(), product.getPrice(), product.getMarca()
        );
        StepVerifier.create(products).expectNext(producto).verifyComplete();
    }


}