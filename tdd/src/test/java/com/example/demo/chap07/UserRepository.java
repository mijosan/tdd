package com.example.demo.chap07;

public interface UserRepository {
    
    public void save(User user);
    public User findById(String id);

}
