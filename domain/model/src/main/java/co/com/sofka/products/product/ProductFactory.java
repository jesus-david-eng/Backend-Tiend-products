package co.com.sofka.products.product;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductFactory {

	public static Mono<Product> create(String id, String name, String description, String urlLogo,String price, String marca) {
		return Mono.just(Product.builder()
			.id(id)
			.name(name)
			.description(description)
			.urlLogo(urlLogo)
			.price(price)
			.marca(marca)
			.build()
		);
	}
}