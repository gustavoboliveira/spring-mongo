package com.gustavoboliveira.springmongo.services;

import com.gustavoboliveira.springmongo.dtos.UserDto;
import com.gustavoboliveira.springmongo.entities.User;
import com.gustavoboliveira.springmongo.repositories.UserRepository;
import com.gustavoboliveira.springmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        List<User> userList = repository.findAll();

        return userList;
    }

    public User findById(String id){
        Optional<User> user = repository.findById(id);

        return user.orElseThrow(
                () -> new ObjectNotFoundException("Object not found"));
    }

    public User insert(User user){
        return repository.insert(user);
    }

    public User fromDto(UserDto userDto){
        User user = new User(userDto.getName(), userDto.getEmail());
        user.setId(userDto.getId());
        return user;
    }

    public void delete(String id){
        findById(id);
        repository.deleteById(id);
    }

    public User update(User user){
        User newUser = repository.findById(user.getId()).get();
        updateData(newUser, user);
        return repository.save(newUser);

    }

    private void updateData(User newUser, User user) {
        newUser.setName(user.getName());
        newUser.setEmail(newUser.getEmail());
    }


}
