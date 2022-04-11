package com.example.twitter.demo.service;

import com.example.twitter.demo.data.TwitterData;
import org.springframework.stereotype.Component;
import twitter4j.TwitterException;

@Component
public interface TwitterService {
    TwitterData getTimeLine() throws TwitterException;
}
