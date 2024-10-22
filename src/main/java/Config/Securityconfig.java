package Config;

import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.WebSecurity;

public interface Securityconfig extends WebSecurityConfigurer<WebSecurity> {
}
