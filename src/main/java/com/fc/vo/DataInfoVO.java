package com.fc.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataInfoVO {
    private Integer code;
    private String msg;
    private Object data; //json数据
    private Long count; // 分页信息：总条数

}