package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserModel;
@Repository
public interface IUserRepository extends JpaRepository<UserModel, Long> {

	Optional<UserModel> findByFirstName(String firstName);

	UserModel save(UserModel user);

	Optional<UserModel> findByEmailAndPassword(String email, String password);

	Optional<UserModel> findByEmail(String email);

	Optional<UserModel> findByPassword(String password);

}
