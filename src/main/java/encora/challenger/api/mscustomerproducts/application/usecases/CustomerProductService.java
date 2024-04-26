package encora.challenger.api.mscustomerproducts.application.usecases;

import encora.challenger.api.mscustomerproducts.domain.model.dto.ProductResponse;
import reactor.core.publisher.Flux;

public interface CustomerProductService {
  Flux<ProductResponse> getActiveProductsByCustomer(String customerId);
}
