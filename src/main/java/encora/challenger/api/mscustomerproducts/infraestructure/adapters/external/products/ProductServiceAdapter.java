package encora.challenger.api.mscustomerproducts.infraestructure.adapters.external.products;

import encora.challenger.api.mscustomerproducts.domain.model.dto.Product;
import encora.challenger.api.mscustomerproducts.domain.port.ProductServicePort;
import encora.challenger.api.mscustomerproducts.infraestructure.adapters.config.properties.ProductProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class ProductServiceAdapter implements ProductServicePort {

  private final WebClient webClient;

  public ProductServiceAdapter(WebClient.Builder webClientBuilder,
      ProductProperties productProperties) {
    this.webClient = webClientBuilder.baseUrl(productProperties.getBaseUrl())
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
  }

  @Override
  public Flux<Product> getActiveProductsByCustomerId(String customerId, String state) {
    return webClient.get()
        .uri(uriBuilder -> uriBuilder
            .path("/customer/{customerId}")
            .queryParam("state", state)
            .build(customerId))
        .retrieve()
        .bodyToFlux(Product.class);
  }

}
