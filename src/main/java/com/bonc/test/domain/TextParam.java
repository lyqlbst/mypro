package com.bonc.test.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by LinYuQiang on 2018/1/9 0009.
 */
@ApiModel(value = "TextBean参数")
@Data
public class TextParam {
    @ApiModelProperty(value = "每页显示条数", name = "pageSize", example = "10")
    private Integer pageSize;
    @ApiModelProperty(value = "第几页", name = "pageNum", example = "1")
    private Integer pageNum;
}
