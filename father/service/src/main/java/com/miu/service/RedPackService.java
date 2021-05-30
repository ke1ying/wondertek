package com.miu.service;


public interface RedPackService {
    void getRedPack(String userId);

    Integer getTotal(String id);

    int updateRemain(String id);
}
