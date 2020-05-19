package com.zjut.noStopStudy.convert;

import com.zjut.noStopStudy.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

public class ListToPage {

    public static Page<Question>convert(List<Question> questionList){
        return new PageImpl<>(questionList);
    }
}
