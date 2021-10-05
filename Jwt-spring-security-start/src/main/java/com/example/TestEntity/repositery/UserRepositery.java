package com.example.TestEntity.repositery;


import com.example.TestEntity.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositery extends JpaRepository<UserEntity,Integer> {
    Optional<UserEntity> findByUsername(String userName);
}
