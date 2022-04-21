package az.unibank.springbootbookstore.dto.request;

import az.unibank.springbootbookstore.dao.entity.ECategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryRequest {

    Long id;
    ECategory categoryName;

}
