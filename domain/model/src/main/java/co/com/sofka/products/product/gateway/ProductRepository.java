package co.com.sofka.products.product.gateway;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import co.com.sofka.products.product.Product;

public interface ProductRepository {

	Mono<Product> save(Product product);

	Flux<Product> findAllProducts();

	Mono<Product> findById(String id);

	Mono<Void> deleteById(String id);

}