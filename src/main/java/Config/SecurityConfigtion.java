package Config;

import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;

public interface SecurityConfigtion extends WebSecurityConfigurer<WebSecurity> {
    void configure(HttpSecurity http) throws Exception;
}
