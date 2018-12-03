package com.gutousu.dynamic_switch_data_source.repository;

import com.gutousu.dynamic_switch_data_source.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IUserRepository extends JpaRepository<user,Integer> {

}
