package az.unibank.springbootbookstore.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateBookRequest {
    Long id;
    Long isbn;
    String tittle;
    Integer totalPages;
    Double rating;
    Set<CategoryRequest> categories;
}
