package com.zzh.mysql.service;

import com.zzh.mysql.model.Demo01;

import java.util.List;
import java.util.Optional;

public interface Demo01Service {
    Optional<Demo01> findByColumn_1(String column_1);
    List<Demo01> finaAll();
    Demo01 save(Demo01 demo01);
    void delete(String column_1);
}
