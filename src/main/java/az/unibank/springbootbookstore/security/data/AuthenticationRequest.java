package az.unibank.springbootbookstore.security.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthenticationRequest {
    private final String username;
    private final String password;
}
