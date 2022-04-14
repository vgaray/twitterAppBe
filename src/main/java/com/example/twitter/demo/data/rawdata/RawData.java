package com.example.twitter.demo.data.rawdata;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class RawData {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String created_at;
    private String text;
    private PublicMetrics public_metrics;
    private String author_id;
    private String id;
}
