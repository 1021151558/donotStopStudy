package com.zjut.noStopStudy.service;

import com.zjut.noStopStudy.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface QuestionService {
    List<Question> findAll(Sort sort);

    Page<Question> findAll(Pageable pageable);

    Question save(Question question);
}
