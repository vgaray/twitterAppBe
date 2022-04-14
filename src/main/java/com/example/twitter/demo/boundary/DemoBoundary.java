package com.example.twitter.demo.boundary;

import com.example.twitter.demo.entity.controller.PortfolioController;
import com.example.twitter.demo.entity.Portfolio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/demo/")
@CrossOrigin("*")
@Slf4j
public class DemoBoundary {

    private final PortfolioController portfolioController;

    public DemoBoundary(PortfolioController portfolioController) {
        this.portfolioController = portfolioController;
    }

    @GetMapping("/portfolio/twitter-time-line/user")
    public Object getDemoTwitterTimeLineByUser(@RequestParam String twitterUserId) throws IOException {
        return portfolioController.getTwitterTimeLineByUserId(twitterUserId);
    }

    @PostMapping("/portfolio/save")
    public Object saveUpdatePortfolio(@Valid @RequestBody Portfolio portfolio) {
        return portfolioController.savePortfolio(portfolio);
    }

}
