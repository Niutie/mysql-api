package com.zzh.mysql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "demo01")
public class Demo01 {
    @Id
    private String column_1;
    @Column
    private String column_2;
    @Column
    private String column_3;

    public String getColumn_1() {
        return column_1;
    }

    public void setColumn_1(String column_1) {
        this.column_1 = column_1;
    }

    public String getColumn_2() {
        return column_2;
    }

    public void setColumn_2(String column_2) {
        this.column_2 = column_2;
    }

    public String getColumn_3() {
        return column_3;
    }

    public void setColumn_3(String column_3) {
        this.column_3 = column_3;
    }

}
