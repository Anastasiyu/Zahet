package com.example.homework2_5.service;

import com.example.homework2_5.exception.UserAlreadyAddedException;
import com.example.homework2_5.exception.UserNotFoundException;
import com.example.homework2_5.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final Collection<User> userCollection;

    public UserService(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    public static List<User> distinct(List<User> users){                  //убрать дубликаты сравнение идет по методу equals
        return  users.stream().distinct().collect(Collectors.toList());
    }


    public User add(String name, int age) {             //метод добавления user
        User user = new User(name, age);

        if (userCollection.contains(user)) {
            throw new UserAlreadyAddedException();  //user уже добавлен
        }
        return user;
    }

    public User remove(String name, int age) {    //метод удаления user
        User user = new User(name, age);
        if (userCollection.contains(user)) {              //если в списке есть user
           userCollection.remove(user);                   // удалить user
            return user;
        }
        throw new UserNotFoundException();  //user не найден
    }

    public User find(String name, int age) {          //поиск по имени и возрасту
        User user = new User(name, age);
        if (userCollection.contains(user)) {
            return user;
        }
        throw new UserNotFoundException(); //user не найден
    }

    public List<User> findAll() {
        return  new ArrayList<>(userCollection);
    }             //вывод списка всех


}
