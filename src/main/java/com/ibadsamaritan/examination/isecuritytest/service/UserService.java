package com.ibadsamaritan.examination.isecuritytest.service;

import com.ibadsamaritan.examination.isecuritytest.model.UserDto;
import com.ibadsamaritan.examination.isecuritytest.repositories.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void registerNewUser(UserDto userDto) {
    }
}
