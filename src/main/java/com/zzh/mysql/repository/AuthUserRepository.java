package com.zzh.mysql.repository;

import com.zzh.mysql.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {
    AuthUser findByAccount(String account);
    AuthUser findByAccountAndPassword(String account, String password);

    @Query(nativeQuery = true, value = "select * from auth_user where name = :name1 or name = :name2")
    List<AuthUser> findBySQL(@Param("name1") String name1, @Param("name2") String name2);

}
