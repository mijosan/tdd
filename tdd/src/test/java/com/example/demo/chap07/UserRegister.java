package com.example.demo.chap07;

public class UserRegister {
    
    private WeakPasswordChecker passwordChecker;
    private MemoryUserRepository userRepository;

    public UserRegister(WeakPasswordChecker passwordChecker, MemoryUserRepository userRepository) {
        this.passwordChecker = passwordChecker;
        this.userRepository = userRepository;
    }

    public void register(String id, String pw, String email) {
        if (passwordChecker.checkPasswordWeak(pw)) {
            throw new WeakPasswordException();
        }

        User user = userRepository.findById(id);
        if (user != null) {
            throw new DupIdException();
        }
        
        userRepository.save(new User("id", "pw", "email"));
    }

}
