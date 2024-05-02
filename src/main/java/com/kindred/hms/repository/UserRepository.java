package com.kindred.hms.repository;

import com.kindred.hms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findUserByUserNameAndPassword(String userName, String password);

    public User findUserByUserName(String userName);
}
