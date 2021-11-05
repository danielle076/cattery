package nl.danielle.cattery.service;

import nl.danielle.cattery.model.Authority;
import nl.danielle.cattery.model.User;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public interface UserService {
    Collection<User> getUsers();
    Optional<User> getUser(String username);
    String createUser(User user);
    void updateUser(String username, User user);
    void deleteUser(String username);
    Set<Authority> getAuthorities(String username);
    void addAuthority(String username, String authority);
    void removeAuthority(String username, String authority);
}
