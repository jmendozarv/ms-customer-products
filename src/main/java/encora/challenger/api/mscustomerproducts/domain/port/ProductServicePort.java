package encora.challenger.api.mscustomerproducts.domain.port;

import encora.challenger.api.mscustomerproducts.domain.model.dto.Product;
import reactor.core.publisher.Flux;

public interface ProductServicePort {
  Flux<Product> getActiveProductsByCustomerId(String customerId,String state);

}
