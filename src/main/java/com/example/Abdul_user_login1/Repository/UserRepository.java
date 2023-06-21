package com.example.Abdul_user_login1.Repository;

import com.example.Abdul_user_login1.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
