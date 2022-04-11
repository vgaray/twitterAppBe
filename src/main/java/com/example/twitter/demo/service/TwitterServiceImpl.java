package com.example.twitter.demo.service;

import com.example.twitter.demo.data.TwitterData;
import org.springframework.stereotype.Service;
import twitter4j.TwitterException;

@Service
public class TwitterServiceImpl implements TwitterService {

    @Override
    public TwitterData getTimeLine() throws TwitterException {
        return null;
    }
}
