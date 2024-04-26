package encora.challenger.api.mscustomerproducts.infraestructure.rest.controller;

import encora.challenger.api.mscustomerproducts.application.services.CustomerProductManagementService;
import encora.challenger.api.mscustomerproducts.domain.model.dto.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.openapitools.api.CustomerProductsApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@Log4j2
public class CustomerProductController implements CustomerProductsApi {

  private final CustomerProductManagementService customerProductManagementService;

  @Override
  public Mono<ResponseEntity<Flux<ProductResponse>>> customerProductsCustomerCustomerIdActiveGet(
      String customerId, String authorization, ServerWebExchange exchange) {
    return customerProductManagementService.getActiveProductsByCustomer(customerId)
        .collectList()  // Convertir a lista
        .map(products -> ResponseEntity.ok(
            Flux.fromIterable(products)))  // Devolver lista de productos
        .switchIfEmpty(Mono.just(ResponseEntity.status(404).body(Flux.empty())));
  }


}
