package co.com.sofka.products.product;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import reactor.core.publisher.Mono;

@Repository
public interface ProductDataRepository extends ReactiveCrudRepository<PorductData, String> , ReactiveQueryByExampleExecutor<PorductData> {
	Mono<Product> findClientDataById(String id);

}