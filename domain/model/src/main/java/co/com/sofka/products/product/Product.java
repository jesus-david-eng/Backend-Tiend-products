package co.com.sofka.products.product;

import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	private  String id;
	private  String name;
	private  String description;
	private  String urlLogo;
	private  String price;
	private  String marca;


}