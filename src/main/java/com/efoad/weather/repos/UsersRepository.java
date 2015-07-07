package com.efoad.weather.repos;

import org.springframework.data.repository.CrudRepository;

import com.efoad.weather.models.User;

//@RepositoryRestResource
public interface UsersRepository extends CrudRepository<User, Integer>{

	User findByemailAndPassword(String email, String password);
}
