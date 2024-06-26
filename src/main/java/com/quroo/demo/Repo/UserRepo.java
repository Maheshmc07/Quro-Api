package com.quroo.demo.Repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quroo.demo.Entity.UserEntity;
@Repository
public interface UserRepo extends JpaRepository<UserEntity,Integer>{

}
