package construction_market.configuration.security;

/**
 * This is an exception class,
 * it is thrown when the Authentication is not successful
 */
public class AuthenticationException extends RuntimeException {
    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
