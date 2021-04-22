package com.example.authproject;

import org.springframework.data.repository.CrudRepository;

public interface DBUserRepository extends CrudRepository<DBUser, Integer> {
    public DBUser findByUsername(String userName);
}
