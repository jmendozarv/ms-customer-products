package encora.challenger.api.mscustomerproducts.infraestructure.adapters.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "application.client.ms-products")
public class ProductProperties {
  private String baseUrl;
}
