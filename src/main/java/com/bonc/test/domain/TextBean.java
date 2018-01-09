package com.bonc.test.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import springfox.documentation.annotations.ApiIgnore;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by LinYuQiang on 2018/1/3 0003.
 */
@ApiModel(value = "TextBean参数")
@Data
public class TextBean {

    @ApiModelProperty(hidden = true)
    private String testId;
    @ApiModelProperty(value = "广告语", name = "testText", example = "德芙巧克力")
    private String testText;
    @ApiModelProperty(hidden = true)
    private Timestamp testTime;
    @ApiModelProperty(value = "登录人", name = "testUser", example = "1")
    private String testUser;
    @ApiModelProperty(hidden = true)
    private String userName;

    public TextBean() {
    }

    public TextBean(String testId, String testText) {
        this.testId = testId;
        this.testText = testText;
    }

    public TextBean(String testId, String testText, String testUser) {
        this.testId = testId;
        this.testText = testText;
        this.testUser = testUser;
    }

    public TextBean(String testId, String testText, Timestamp testTime, String testUser,String userName) {
        this.testId = testId;
        this.testText = testText;
        this.testTime = testTime;
        this.testUser = testUser;
        this.userName = userName;
    }
}
