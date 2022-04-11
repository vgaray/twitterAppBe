package com.example.twitter.demo.boundary;

import com.example.twitter.demo.controller.PortfolioController;
import com.example.twitter.demo.service.TwitterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import twitter4j.TwitterException;

@RestController
@RequestMapping("/demo/")
@CrossOrigin("*")
@Slf4j
public class DemoBoundary {

    private final TwitterService twitterService;
    private final PortfolioController portfolioController;

    public DemoBoundary(TwitterService twitterService, PortfolioController portfolioController) {
        this.twitterService = twitterService;
        this.portfolioController = portfolioController;
    }

    @GetMapping("/twitter-time-line")
    public Object getDemoTwitterTimeLine(@RequestParam String twitterUserId, @Nullable @RequestParam Integer limit) throws TwitterException {
        return portfolioController.getPortfolioByTwitterUserId(twitterUserId);
    }

}
