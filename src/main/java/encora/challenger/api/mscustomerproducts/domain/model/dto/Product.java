package encora.challenger.api.mscustomerproducts.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
public class Product {
  private String id;
  private String name;
  private String description;
  private String documentNumber;
  private String state;
}
