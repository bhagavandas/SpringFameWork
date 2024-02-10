package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CustomerModel;




@Repository
public interface IUserRepository extends JpaRepository<CustomerModel, Long> {

	Optional<CustomerModel> findByFirstName(String firstName);

	CustomerModel save(CustomerModel user);

	Optional<CustomerModel> findByEmailAndPassword(String email, String password);

	Optional<CustomerModel> findByEmail(String email);

	Optional<CustomerModel> findByPassword(String password);

	Optional<CustomerModel> deleteByFirstName(Optional<CustomerModel> customerModel);

}
