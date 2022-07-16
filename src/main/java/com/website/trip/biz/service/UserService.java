package com.website.trip.biz.service;

import com.website.trip.biz.dto.User;

public interface UserService {

    void create(User parameter);
    void modify(User parameter);
    void modifyPassword(User parameter);
    void remove(User parameter);

    User detail(User parameter);

}
