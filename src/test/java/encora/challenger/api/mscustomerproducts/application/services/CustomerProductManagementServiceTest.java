package encora.challenger.api.mscustomerproducts.application.services;

import static org.mockito.Mockito.when;

import encora.challenger.api.mscustomerproducts.application.mapper.ProductResponseMapper;
import encora.challenger.api.mscustomerproducts.domain.model.constants.ProductConstants;
import encora.challenger.api.mscustomerproducts.domain.model.dto.Product;
import encora.challenger.api.mscustomerproducts.domain.model.dto.ProductResponse;
import encora.challenger.api.mscustomerproducts.domain.port.ProductServicePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class CustomerProductManagementServiceTest {
  @Mock
  private ProductServicePort productServicePort;

  @Mock
  private ProductResponseMapper productResponseMapper;

  @InjectMocks
  private CustomerProductManagementService service;
  @Test
  void getActiveProductsByCustomer() {
    // Simulación de productos
    var product = new Product(); // Crea una instancia del objeto Product
    var productResponse = new ProductResponse(); // Crea una instancia de ProductResponse
    when(productServicePort.getActiveProductsByCustomerId("customer123", ProductConstants.ACTIVE_PRODUCT))
        .thenReturn(Flux.just(product));

    when(productResponseMapper.toDTO(product)).thenReturn(productResponse);

    // Prueba el método
    StepVerifier.create(service.getActiveProductsByCustomer("customer123"))
        .expectNext(productResponse)
        .verifyComplete();
  }
}