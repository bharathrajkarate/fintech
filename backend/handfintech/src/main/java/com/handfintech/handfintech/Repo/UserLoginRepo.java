package com.handfintech.handfintech.Repo;

import com.handfintech.handfintech.Entity.UserLoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginRepo extends JpaRepository<UserLoginEntity,Integer> {

    @Query(value = "select count(*) from user_login_tbl where user_password  = :user_password and user_name = :user_name and user_del_flg ='N'",nativeQuery = true)
    int userLogin(@Param("user_name") String user_name,@Param("user_password") String user_password);
}
