package com.zzh.mysql.service;

import com.zzh.mysql.model.Demo01;

import java.util.List;

public interface Demo01Service {
    Demo01 findByColumn_1(int column_1);
    List<Demo01> finaAll();
    Demo01 save(Demo01 demo01);
    void delete(int column_1);
}
