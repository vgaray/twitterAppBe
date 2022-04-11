package com.example.twitter.demo.data.rawdata;

import lombok.Data;

@Data
public class RawData {
    private String created_at;
    private String text;
    private PublicMetrics publicMetrics;
    private String author_id;
    private String id;
}
