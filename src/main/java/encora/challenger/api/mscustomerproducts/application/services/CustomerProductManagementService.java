package encora.challenger.api.mscustomerproducts.application.services;

import encora.challenger.api.mscustomerproducts.application.mapper.ProductResponseMapper;
import encora.challenger.api.mscustomerproducts.application.usecases.CustomerProductService;
import encora.challenger.api.mscustomerproducts.domain.model.constants.ProductConstants;
import encora.challenger.api.mscustomerproducts.domain.model.dto.ProductResponse;
import encora.challenger.api.mscustomerproducts.domain.port.ProductServicePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class CustomerProductManagementService implements CustomerProductService {

  private final ProductServicePort productServicePort;
  private final ProductResponseMapper productResponseMapper;

  @Override
  public Flux<ProductResponse> getActiveProductsByCustomer(String customerId) {
    return productServicePort.getActiveProductsByCustomerId(customerId,
        ProductConstants.ACTIVE_PRODUCT).map(productResponseMapper::toDTO);
  }
}
