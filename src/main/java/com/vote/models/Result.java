package com.vote.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result {
    public Result(Integer yay, Integer nay) {
        this.setYay(yay);
        this.setNay(nay);
    }

    private Integer yay;
    private Integer nay;
}
