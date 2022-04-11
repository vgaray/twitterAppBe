package com.example.twitter.demo.data;

import com.example.twitter.demo.data.includes.Includes;
import com.example.twitter.demo.data.meta.Meta;
import com.example.twitter.demo.data.rawdata.RawData;
import lombok.Data;

import java.util.List;

@Data
public class TwitterData {
    private List<RawData> data;
    private Includes includes;
    private Meta meta;

}
