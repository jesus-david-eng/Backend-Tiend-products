package co.com.sofka.products;


import co.com.sofka.products.product.ProductController;
import co.com.sofka.products.product.Product;
import co.com.sofka.products.product.UseCaseProducts;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@WebFluxTest(ProductController.class)
public class TestProductController {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private UseCaseProducts useCaseProducts;


    private final Product product = Product.builder()
            .id("22")
            .name("Samsumg 6")
            .description("ultera camara")
            .urlLogo("www.google.com")
            .price("22.77")
            .marca("Ipad")
            .build();
    private final Product productF = Product.builder()
            .id("22")
            .name("Samsumg 6")
            .description("ultera camara")
            .urlLogo("www.google.com")
            .price("22.77")
            .marca("Ipad")
            .build();

    @Test
    public void testGetAllClients(){

        final WebTestClient.ResponseSpec spec = webTestClient.get().uri("/api/product").exchange();
        spec.expectBodyList(Product.class).consumeWith(res -> {
            final HttpStatus status = res.getStatus();
            assertThat(status.is2xxSuccessful()).isTrue();
        });
    }

    @Test
    public void testGetId(){
        final WebTestClient.ResponseSpec spec = webTestClient.get().uri("/api/product/search/{id}",product.getId()).exchange();
        spec.expectBodyList(Product.class).consumeWith(res -> {
            final HttpStatus status = res.getStatus();
            assertThat(status.is2xxSuccessful()).isTrue();
        });

    }

    @Test
    public void testCreateProduct(){
        Mono<Product> productUni = Mono.just(product);
        webTestClient.post()
                .uri("/api/product/create")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(productUni, Product.class)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void testUpdateProductById() {

        webTestClient.put()
                .uri("/api/product/update/{id}",productF.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(productF),Product.class)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void testDeleteProduct() {
        webTestClient.delete()
                .uri("/api/product/delete/{id}", product.getId())
                .exchange()
                .expectStatus().isOk();
    }


}
