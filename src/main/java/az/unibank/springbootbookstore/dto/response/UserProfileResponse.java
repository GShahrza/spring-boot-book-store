package az.unibank.springbootbookstore.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserProfileResponse {

    Long id;
    String firstName;
    String lastName;
}
