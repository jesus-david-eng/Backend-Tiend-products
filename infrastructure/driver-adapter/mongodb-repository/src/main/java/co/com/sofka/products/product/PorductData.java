package co.com.sofka.products.product;

import java.util.List;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Data
@Document(collection = "Productos")
public class PorductData {

	@Id
	private String id;
	private String name;
	private String description;
	private String urlLogo;
	private String price;
	private String marca;

}