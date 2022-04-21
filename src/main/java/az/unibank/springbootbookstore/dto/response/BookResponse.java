package az.unibank.springbootbookstore.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookResponse {

    Long id;
    String tittle;
    Long isbn;
    Integer totalPages;
    Double rating;
    List<CategoryResponse> categories;
}
