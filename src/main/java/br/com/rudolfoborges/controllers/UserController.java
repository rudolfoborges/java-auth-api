package br.com.rudolfoborges.controllers;

import br.com.rudolfoborges.models.User;
import br.com.rudolfoborges.repositories.UserRepository;
import br.com.rudolfoborges.utils.serializers.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<UserResponse> getAll(){
        List<User> users = userRepository.findAllByOrderByName();
        Stream<UserResponse> userResponseStream = users.stream().map(user -> new UserResponse(user));
        return userResponseStream.collect(Collectors.toList());
    }

}
