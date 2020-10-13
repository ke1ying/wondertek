package com.miu.service;

import com.miu.entity.UserRedpack;

public interface UserRedPackService {
    void getRedPack(String message);

    void insertGradReadPack(UserRedpack urp);
}
