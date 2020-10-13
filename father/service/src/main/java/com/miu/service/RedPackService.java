package com.miu.service;

import com.miu.entity.UserRedpack;

public interface RedPackService {
    void getRedPack(String userId);

    Integer getTotal(String id);

    int updateRemain(String id);
}
