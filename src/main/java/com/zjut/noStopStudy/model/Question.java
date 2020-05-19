package com.zjut.noStopStudy.model;

import com.zjut.noStopStudy.model.modelUtil.QuestionId;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@Entity(name = "question")
@IdClass(QuestionId.class)
public class Question extends QuestionId{

    private String name;

    private String content;

    private String role;

    public Question(){
        super();
    }

    public Question(String name, String content, Integer userId, String role,String createTime) {
        super(userId,createTime);
        this.name = name;
        this.content = content;
        this.role = role;
    }
}
