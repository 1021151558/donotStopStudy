package com.zjut.noStopStudy.model.modelUtil;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@Data
public class QuestionId implements Serializable {

    @Id
    private Integer userId;
    @Id
    private String createTime;

    public QuestionId(){
        super();
    }

    public QuestionId(Integer userId, String createTime) {
        this.userId = userId;
        this.createTime = createTime;
    }
}
