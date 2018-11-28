package com.zzh.mysql.service.impl;

import com.zzh.mysql.model.Demo01;
import com.zzh.mysql.repository.Demo01Repository;
import com.zzh.mysql.service.Demo01Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Demo01ServiceImpl implements Demo01Service {
    @Resource
    private Demo01Repository demo01Repository;

    @Override
    public Demo01 findByColumn_1(int column_1) {
        return demo01Repository.findById(String.valueOf(column_1)).get();
    }

    @Override
    public List<Demo01> finaAll() {
        return demo01Repository.findAll();
    }

    @Override
    public Demo01 save(Demo01 demo01) {
        return demo01Repository.save(demo01);
    }

    @Override
    public void delete(int column_1) {
        demo01Repository.deleteById(String.valueOf(column_1));
        System.out.println("第 " + column_1 + " 行数据已经删除！");
    }
}
