package co.com.sofka.products;

import co.com.sofka.products.product.UseCaseProducts;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UseCaseConfigTest {

    @Autowired
    private UseCaseProducts useCaseProducts;

    @Test
    public void testUseCase(){
        assertThat(useCaseProducts).isNotNull();
    }

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void objectMapper() {
        assertThat(objectMapper).isNotNull();
    }
}
