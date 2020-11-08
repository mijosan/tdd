package com.example.demo.chap07;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserRegister {
    
    private WeakPasswordChecker passwordChecker;
    private MemoryUserRepository userRepository;
    private EmailNotifier emailNotifier;

    public void register(String id, String pw, String email) {
        if (passwordChecker.checkPasswordWeak(pw)) {
            throw new WeakPasswordException();
        }

        User user = userRepository.findById(id);
        if (user != null) {
            throw new DupIdException();
        }
        
        userRepository.save(new User(id, pw, email));

        emailNotifier.sendRegisterEmail(email);
    }

}
