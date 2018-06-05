package com.ncs.zhilongcloud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ncs.zhilongcloud.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
