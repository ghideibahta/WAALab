package com.example.lab2.repo;

import com.example.lab2.domain.Logger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoggerRepo extends CrudRepository<Logger, Long> {

        List<Logger> findAll();
    }

