package co.com.sofka.products.product;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestProductData {

	private String id;
	private String name;
	private String description;
	private String urlLogo;
	private String price;
	private String marca;


}