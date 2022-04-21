package az.unibank.springbootbookstore.security.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AuthenticationResponse {
    private final String jwt;
}
