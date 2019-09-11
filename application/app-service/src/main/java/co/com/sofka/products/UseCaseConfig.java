package co.com.sofka.products;

import lombok.Data;
import org.reactivecommons.utils.ObjectMapper;
import org.reactivecommons.utils.ObjectMapperImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.sofka.products.product.UseCaseProducts;
import co.com.sofka.products.product.gateway.ProductRepository;

@Data
@Configuration
public class UseCaseConfig {

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapperImp();
	}

	@Bean
	public UseCaseProducts crudClientUseCase(ProductRepository productRepository) {
		return new UseCaseProducts(productRepository);
	}

}