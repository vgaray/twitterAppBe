package com.example.twitter.demo.dto;

import com.example.twitter.demo.data.TwitterData;
import com.example.twitter.demo.entity.Portfolio;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PortfolioTwitterDto {

    private Portfolio portfolio;
    private TwitterData twitterData;

}
