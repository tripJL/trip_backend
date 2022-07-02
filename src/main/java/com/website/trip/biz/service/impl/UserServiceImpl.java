package com.website.trip.biz.service.impl;

import com.website.trip.biz.dao.UserDao;
import com.website.trip.biz.dto.User;
import com.website.trip.biz.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    public void create(User parameter) {

        userDao.insert(parameter);
    }
}
