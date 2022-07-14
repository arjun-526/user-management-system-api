package com.valmiki.user.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valmiki.user.api.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
