package co.com.sofka.products.product;

import lombok.Data;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import co.com.sofka.products.product.gateway.ProductRepository;
import static co.com.sofka.products.UniqueIDGenerator.uuid;

@Data
@AllArgsConstructor
public class UseCaseProducts {

	private final ProductRepository productRepository;

	public Mono<Product> create(String name, String description, String urlLogo, String price, String marca) {
		return uuid().flatMap(id -> ProductFactory.create(id, name, description, urlLogo, price, marca)
		).flatMap(productRepository::save);
	}

	public Flux<Product> findAllProducts() {
		return productRepository.findAllProducts();
	}

	public Mono<Product> findById(String id) {
		return productRepository.findById(id);
	}

	public Mono<Product> update(String id, String name, String description, String urlLogo, String price, String marca) {
		return productRepository.findById(id).flatMap(product -> ProductFactory.create(
			id,
			name,
			description,
			urlLogo,
			price,
			marca
			)
		).flatMap(productRepository::save);
	}

	public Mono<Void> deleteById(String id) {
		return productRepository.deleteById(id);
	}

}