package construction_market.configuration.security;

/**
 * Created by x on 8.9.2019 г..
 */
public class AuthenticationException extends RuntimeException {
    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
