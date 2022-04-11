package com.example.twitter.demo.repository;

import com.example.twitter.demo.entity.Portfolio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends CrudRepository<Portfolio, Integer> {
    Portfolio findAllByTwitterUserId(String twitterUserId);
}