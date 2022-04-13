package com.example.twitter.demo.proxy.twitter.impl;

import com.example.twitter.demo.data.TwitterData;
import com.example.twitter.demo.proxy.twitter.TwitterConnectionApi;
import com.example.twitter.demo.proxy.twitter.TwitterConnectionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TwitterConnectionApiImpl implements TwitterConnectionService {

    private final TwitterConnectionApi twitterConnectionApi;
    @Value("${com.twitter.demo.twitter.token}")
    private String twitterToken;

    public TwitterConnectionApiImpl(TwitterConnectionApi twitterConnectionApi) {
        this.twitterConnectionApi = twitterConnectionApi;
    }


    @Override
    public TwitterData getTimeLineByTwitterId(String id) throws IOException {
        return twitterConnectionApi.getTimeLineByTwitterId(id, twitterToken)
                .execute()
                .body();
    }

}
