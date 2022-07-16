package com.website.trip.biz.service.impl;

import com.website.trip.biz.dao.UserDao;
import com.website.trip.biz.dto.Board;
import com.website.trip.biz.dto.BoardFileMapping;
import com.website.trip.biz.dto.User;
import com.website.trip.biz.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    public void create(User parameter) {

        // 비밀번호 암호화 로직 필요
        userDao.insert(parameter);
    }

    @Override
    public void modify(User parameter) {
        userDao.update(parameter);
    }

    @Override
    public void modifyPassword(User parameter) {

        // 비밀번호 암호화 로직 필요
        userDao.updateByPassword(parameter);
    }

    @Override
    public void remove(User parameter) {
        userDao.delete(parameter);
    }

    @Override
    @Transactional
    public User detail(User parameter) {
        return userDao.selectOne(parameter);
    }
}
