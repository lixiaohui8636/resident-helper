package com.residenthelper.server.repository;

import com.residenthelper.server.service.user.bean.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @Author: Lee
 * @Date: 6/21/21
 * @Desc:
 */
public interface UserRepository extends JpaRepository<UserBean,Long> {

    /**
     * 查询用户
     * @param phone
     * @return
     */
    @Query(value = "SELECT * FROM the_user WHERE phone =:phone AND status != 'ZHUXIAO'", nativeQuery = true)
    public UserBean findUserBeanByPhone(@Param("phone") String phone);
}
