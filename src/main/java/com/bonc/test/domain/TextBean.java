package com.bonc.test.domain;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by LinYuQiang on 2018/1/3 0003.
 */
@Data
public class TextBean {
    private String testId;
    private String testText;
    private Timestamp testTime;
    private String testUser;

    public TextBean() {
    }

    public TextBean(String testId, String testText, String testUser) {
        this.testId = testId;
        this.testText = testText;
        this.testUser = testUser;
    }

    public TextBean(String testId, String testText, Timestamp testTime, String testUser) {
        this.testId = testId;
        this.testText = testText;
        this.testTime = testTime;
        this.testUser = testUser;
    }
}
