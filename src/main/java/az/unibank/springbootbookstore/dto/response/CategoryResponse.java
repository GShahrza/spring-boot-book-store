package az.unibank.springbootbookstore.dto.response;

import az.unibank.springbootbookstore.dao.entity.ECategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryResponse {

    Long id;
    ECategory categoryName;
}
