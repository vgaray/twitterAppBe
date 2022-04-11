package com.example.twitter.demo.data.meta;

import lombok.Data;

@Data
public class Meta {
    private String result_count;
    private String newest_id;
    private String oldest_id;
    private String next_token;
}
