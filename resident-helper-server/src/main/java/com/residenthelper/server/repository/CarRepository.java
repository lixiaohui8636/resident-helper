package com.residenthelper.server.repository;

import com.residenthelper.server.service.car.bean.CarBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @Author: Lee
 * @Date: 6/21/21
 * @Desc:
 */
public interface CarRepository extends JpaRepository<CarBean,Long> {

    /**
     * 查询用户
     * @param carNumber
     * @return
     */
    @Query(value = "SELECT * FROM the_car WHERE car_number like :carNumber AND status ='ENABLED'", nativeQuery = true)
    public CarBean findCarByLike(@Param("carNumber") String carNumber);



}
