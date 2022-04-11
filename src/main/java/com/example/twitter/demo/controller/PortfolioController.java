package com.example.twitter.demo.controller;

import com.example.twitter.demo.entity.Portfolio;
import com.example.twitter.demo.repository.PortfolioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PortfolioController {
    private final PortfolioRepository portfolioRepository;

    public PortfolioController(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    public Iterable<Portfolio> getPortfolios() {
        return portfolioRepository.findAll();
    }

    public Portfolio getPortfolioByTwitterUserId(String id) {
        return portfolioRepository.findAllByTwitterUserId(id);
    }


}
