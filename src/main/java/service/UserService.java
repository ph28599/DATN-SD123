package service;

import dto.UserDTO;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class UserService {

    private final Set<String> existingUsernames = new HashSet<>();

    public String registerUser(String username, String email, String phoneNumber, String password, String confirmPassword) {
        if (username.length() < 2) {
            return "Tên đăng nhập phải có tối thiểu 2 ký tự.";
        }
        if (existingUsernames.contains(username)) {
            return "Tên đăng nhập đã tồn tại.";
        }
        if (!isValidEmail(email)) {
            return "Email không hợp lệ.";
        }
        if (phoneNumber.length() < 10) {
            return "Số điện thoại phải có tối thiểu 10 ký tự.";
        }
        if (password.length() < 6) {
            return "Mật khẩu phải có tối thiểu 6 ký tự.";
        }
        if (!password.equals(confirmPassword)) {
            return "Mật khẩu không khớp.";
        }

        // Đăng ký thành công
        existingUsernames.add(username);
        return "Đăng ký thành công với vai trò: CUSTOMER";
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    public void registerNewUser(UserDTO userDto) {
    }
}


