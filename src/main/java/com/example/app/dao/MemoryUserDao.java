package com.example.app.dao;

import com.example.app.dao.base.UserDao;
import com.example.app.dao.entity.Movie;
import com.example.app.dao.entity.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MemoryUserDao implements UserDao{

    private static List<User> users = new ArrayList<>();
    private static Long idSequence = 1L;

    MemoryUserDao() {}

    @Override
    public Long save(User user) {
        user.setId(idSequence++);
        users.add(user);
        return user.getId();
    }

    @Override
    public List<User> findAll() {
        return Collections.unmodifiableList(users);
    }

    @Override
    public Optional<User> findById(Long id) {
        return this.users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    @Override
    public boolean update(User userToUpdate) {
        boolean isUpdate=false;
        List<User> tempList = new ArrayList<>();
        for (User u:users) {
            if (u.getId() == userToUpdate.getId()) {
                u = userToUpdate;
                isUpdate=true;
            }
            tempList.add(u);
        }
        this.users = tempList;
        return isUpdate;
    }

    @Override
    public void delete(Long id) {
        this.users = this.users.stream()
                .filter(user -> user.getId() != id)
                .collect(Collectors.toList());
    }
}
