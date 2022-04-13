package com.example.twitter.demo.controller;

import com.example.twitter.demo.data.TwitterData;
import com.example.twitter.demo.entity.Portfolio;
import com.example.twitter.demo.proxy.twitter.TwitterConnectionService;
import com.example.twitter.demo.repository.PortfolioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class PortfolioController {
    private final PortfolioRepository portfolioRepository;
    private final TwitterConnectionService twitterConnectionService;
    public PortfolioController(PortfolioRepository portfolioRepository, TwitterConnectionService twitterConnectionService) {
        this.portfolioRepository = portfolioRepository;
        this.twitterConnectionService = twitterConnectionService;
    }

    public Iterable<Portfolio> getPortfolios() {
        return portfolioRepository.findAll();
    }

    public Portfolio getPortfolioByTwitterUserId(String id) {
        return portfolioRepository.findByTwitterUserId(id);
    }

    public TwitterData getTwitterTimeLine(String id) throws IOException {
        return twitterConnectionService.getTimeLineByTwitterId(id);
    }

}
