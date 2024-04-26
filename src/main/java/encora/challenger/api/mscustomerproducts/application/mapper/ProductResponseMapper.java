package encora.challenger.api.mscustomerproducts.application.mapper;

import encora.challenger.api.mscustomerproducts.domain.model.dto.Product;
import encora.challenger.api.mscustomerproducts.domain.model.dto.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductResponseMapper {


  @Mapping(source = "id", target = "id")
  @Mapping(source = "state", target = "state")
  @Mapping(source = "description", target = "description")
  @Mapping(source = "name", target = "name")
  @Mapping(source = "documentNumber", target = "documentNumber")
  ProductResponse toDTO(Product product);

}
