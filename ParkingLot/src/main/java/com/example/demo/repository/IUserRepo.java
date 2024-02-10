package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.UserModel;

@Repository
public interface IUserRepo extends JpaRepository<UserModel, Integer>{

	Optional<UserModel> findByEmailAndPassword(String email, String password);

	Optional<UserModel> findByEmail(String email);

	Optional<UserModel> findByPassword(String password);

	Optional<UserModel> findById(Long slotId);

	UserModel findByUserId(Long slotId);

}
