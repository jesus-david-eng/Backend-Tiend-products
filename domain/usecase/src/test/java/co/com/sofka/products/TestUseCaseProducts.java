package co.com.sofka.products;

import co.com.sofka.products.product.Product;
import co.com.sofka.products.product.UseCaseProducts;
import co.com.sofka.products.product.gateway.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestUseCaseProducts {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private UseCaseProducts useCaseProducts;

    private Product product = Product.builder()
            .id("22")
            .name("Samsumg 6")
            .description("ultera camara")
            .urlLogo("www.google.com")
            .price("22.77")
            .marca("Ipad")
            .build();

    private Product product2 = Product.builder()
            .id("22")
            .name("Samsumg 6")
            .description("ultera camara")
            .urlLogo("www.google.com")
            .price("22.77")
            .marca("Ipad")
            .build();

    private Flux<Product> productosE = Flux.just(product,product2);

    @Before
    public void setUp(){

        Mockito.when(productRepository.save(ArgumentMatchers.any())).thenReturn(Mono.just(product));
        Mockito.when(productRepository.findById(ArgumentMatchers.any())).thenReturn(Mono.just(product));

    }


    @Test
    public void testDeleteProduct(){
        useCaseProducts.deleteById(product.getId());
        verify(productRepository, times(1)).deleteById(product.getId());

    }

    @Test
    public void testFindAllProducts(){
        when(useCaseProducts.findAllProducts()).thenReturn(productosE);
        Flux<Product> productosU = useCaseProducts.findAllProducts();
        verify(productRepository,times(1)).findAllProducts();
        assertEquals(productosU,productosE);
    }

    @Test
    public void testGetProductFindById(){
        when(productRepository.findById(product.getId())).thenReturn(Mono.just(product));
        Mono<Product> idProduct = useCaseProducts.findById(product.getId());
        assertEquals(idProduct.block(), product);
    }


    @Test
    public void testSaveProduct(){

        final Mono<Product> productUni = useCaseProducts.create(product.getName(), product.getDescription(), product.getUrlLogo(), product.getPrice(), product.getMarca());
        assertEquals(productUni.block(),product);
        StepVerifier.create(productUni).expectNext(product).verifyComplete();
    }

    @Test
    public void testUpdateProduct(){

        final Mono<Product> productUni = useCaseProducts.update(product.getId(),product.getName(), product.getDescription(), product.getUrlLogo(), product.getPrice(), product.getMarca());
        assertEquals(productUni.block(),product);
        StepVerifier.create(productUni).expectNext(product).verifyComplete();
    }

}
