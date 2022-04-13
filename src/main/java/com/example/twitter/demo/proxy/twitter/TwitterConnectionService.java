package com.example.twitter.demo.proxy.twitter;

import com.example.twitter.demo.data.TwitterData;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.http.POST;

import java.io.IOException;

public interface TwitterConnectionService {

    TwitterData getTimeLineByTwitterId(String id) throws IOException;

}
