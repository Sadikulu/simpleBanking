package com.eteration.simplebanking.services;

import com.eteration.simplebanking.exceptions.ConflictException;
import com.eteration.simplebanking.exceptions.ResourceNotFoundException;
import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.exceptions.ErrorMessage;
import com.eteration.simplebanking.model.User;
import com.eteration.simplebanking.model.request.RegisterRequest;
import com.eteration.simplebanking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccountService accountService;

    public UserService(UserRepository userRepository, @Lazy AccountService accountService) {
        this.userRepository = userRepository;
        this.accountService = accountService;
    }

    public User addUser(RegisterRequest registerRequest) throws ConflictException, ResourceNotFoundException {
        User user=null;
        if(userRepository.existsByEmail(registerRequest.getEmail())){
            throw new ConflictException(
                    String.format(ErrorMessage.EMAIL_ALREADY_CONFIRMED_MESSAGE, registerRequest.getEmail()));
        }else{
            user=new User();
            user.setEmail(registerRequest.getEmail());
            user.setFirstName(registerRequest.getFirstName());
            user.setLastName(registerRequest.getLastName());
            user.setPassword(registerRequest.getPassword());
            user.setPhoneNumber(registerRequest.getPhoneNumber());
            Account account=accountService.createAccount(user);
            user.setAccount(account);
            userRepository.save(user);
        }
        return user;
    }

}
