package co.com.sofka.products.product;

import org.springframework.stereotype.Repository;
import co.com.sofka.reactive_mongodb_repository_common.AdapterOperations;
import co.com.sofka.products.product.gateway.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.reactivecommons.utils.ObjectMapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class ProductRepositoryAdapter extends AdapterOperations<Product, PorductData, String , ProductDataRepository> implements ProductRepository {

	@Autowired
	public ProductRepositoryAdapter(ProductDataRepository repository , ObjectMapper mapper) {
		super(repository , mapper , obj -> mapper.mapBuilder(obj , Product.ProductBuilder.class).build());
	}

	@Override
	public Flux<Product> findAllProducts() {
		return doQueryMany(repository.findAll());
	}

	@Override
	public Mono<Product> findById(String id) {
		return repository.findClientDataById(id);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return repository.deleteById(id);
	}


}