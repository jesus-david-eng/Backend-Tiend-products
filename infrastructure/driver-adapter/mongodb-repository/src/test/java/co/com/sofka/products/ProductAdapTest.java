package co.com.sofka.products;

import co.com.sofka.products.product.Product;
import co.com.sofka.products.product.ProductRepositoryAdapter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProductAdapTest {

    @Autowired
    private ProductRepositoryAdapter productRepositoryAdapter;

    private final Product product = Product.builder()
            .id("22")
            .name("Samsumg 6")
            .description("ultera camara")
            .urlLogo("www.google.com")
            .price("22.77")
            .marca("Ipad")
            .build();

    @Before
    public void saveInitialData() {
        final Flux<Product> result = Flux.just(
                productRepositoryAdapter.save((product)).block(), productRepositoryAdapter.save((product)).block());
        StepVerifier.create(result).expectNext(product, product).verifyComplete();

    }

    @Test
    public void testGetAllProducts() {
        StepVerifier.create(productRepositoryAdapter.findAllProducts().collectList())
                .assertNext(bills -> assertThat(bills).contains(product, product)).verifyComplete();
    }

    @Test
    public void testDeleteBill(){
        final Mono<Void> mono = productRepositoryAdapter.deleteById(product.getId());
        StepVerifier.create(mono).verifyComplete();
    }


}
