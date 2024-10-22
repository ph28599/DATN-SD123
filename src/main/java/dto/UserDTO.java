package dto;

import com.sun.istack.NotNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class UserDTO {
    @NotNull
    @Size(min = 2, message = "Username must be at least 2 characters")
    private String username;

    @Email(message = "Email should be valid")
    private String email;

    @NotNull
    @Size(min = 10, message = "Phone number must be at least 10 digits")
    private String phoneNumber;

    @NotNull
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @NotNull
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Object getPassword() {
        return password;
    }

    public Object getConfirmPassword() {
        return confirmPassword;
    }
}
