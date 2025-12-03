package com.era.kordim.service.impl;

import com.era.kordim.entity.Permission;
import com.era.kordim.entity.User;
import com.era.kordim.repository.PermissonRepository;
import com.era.kordim.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MyService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PermissonRepository permissionRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (Objects.nonNull(user)) {
            return user;
        }
        throw new UsernameNotFoundException("User Not Found");
    }

    public void registr(User model) {
        User check = userRepository.findByEmail(model.getEmail());
        if (check == null) {

            Permission permission = permissionRepository.findByName("ROLE_USER");
            if (permission == null) {
                permission = new Permission();
                permission.setName("ROLE_USER");
                permissionRepository.save(permission);
            }

            model.setPassword(passwordEncoder.encode(model.getPassword()));
            model.setPermissions(List.of(permission));

            userRepository.save(model);
        }
    }
}
