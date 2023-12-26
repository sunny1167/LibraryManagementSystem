package com.jio.librarymanagementsystem.service;

import com.jio.librarymanagementsystem.model.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private List<User> users = new ArrayList<>();
    private long nextUserId = 1;

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> foundUser = users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
        return foundUser.orElse(null);
    }

    @Override
    public User createUser(User user) {
        user.setId(nextUserId++);
        users.add(user);
        return user;
    }

    @Override
    public User updateUser(Long id, User updatedUser) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getId().equals(id)) {
                updatedUser.setId(id);
                users.set(i, updatedUser);
                return updatedUser;
            }
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        users.removeIf(user -> user.getId().equals(id));
    }
}
