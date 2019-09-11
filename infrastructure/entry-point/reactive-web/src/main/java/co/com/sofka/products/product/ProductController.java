package co.com.sofka.products.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import static reactor.core.publisher.Mono.just;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = "/api")
public class ProductController {

	private final UseCaseProducts useCaseProducts;

	public ProductController(UseCaseProducts useCaseProducts) {
		this.useCaseProducts = useCaseProducts;
	}


	@PostMapping("/product/create")
	public Mono<Product> create(@RequestBody RequestProductData productData) {
		return useCaseProducts.create(
			productData.getName(),
			productData.getDescription(),
			productData.getUrlLogo(),
			productData.getPrice(),
			productData.getMarca()
		);
	}

	@GetMapping(value = "/product")
	public Flux<Product> findAllProducts() {
		return useCaseProducts.findAllProducts();
	}

	@GetMapping(value = "/product/search/{id}")
	public Mono<Product> findById(@PathVariable("id") String id) {
		return useCaseProducts.findById(id);
	}

	@PutMapping(value = "/product/update/{id}")
	public Mono<Product> update(@PathVariable("id") String id , @RequestBody RequestProductData productData) {
		return useCaseProducts.update(
			id,
			productData.getName(),
			productData.getDescription(),
			productData.getUrlLogo(),
			productData.getPrice(),
			productData.getMarca()
		);
	}


	@DeleteMapping("/product/delete/{id}")
	public Mono<Void> deleteById(@PathVariable("id") String id) {
		return useCaseProducts.deleteById(id);
	}
}