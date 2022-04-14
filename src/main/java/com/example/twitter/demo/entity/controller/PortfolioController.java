package com.example.twitter.demo.entity.controller;

import com.example.twitter.demo.dto.PortfolioTwitterDto;
import com.example.twitter.demo.entity.Portfolio;
import com.example.twitter.demo.proxy.twitter.TwitterConnectionService;
import com.example.twitter.demo.repository.PortfolioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.io.IOException;
import java.util.Set;

@Slf4j
@Component
public class PortfolioController {
    private final PortfolioRepository portfolioRepository;
    private final TwitterConnectionService twitterConnectionService;
    private final Validator validator;

    public PortfolioController(PortfolioRepository portfolioRepository, TwitterConnectionService twitterConnectionService, Validator validator) {
        this.portfolioRepository = portfolioRepository;
        this.twitterConnectionService = twitterConnectionService;
        this.validator = validator;
    }

    private Portfolio getPortfolioByTwitterUserId(String id) {
        return portfolioRepository.findByTwitterUserId(id);
    }

    public PortfolioTwitterDto getTwitterTimeLineByUserId(String id) throws IOException {
        return PortfolioTwitterDto.builder()
                .portfolio(getPortfolioByTwitterUserId(id))
                .twitterData(twitterConnectionService.getTimeLineByTwitterId(id))
                .build();
    }

    public Portfolio savePortfolio(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }
}
