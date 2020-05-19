package com.zjut.noStopStudy.service.impl;

import com.zjut.noStopStudy.dao.QuestionDao;
import com.zjut.noStopStudy.model.Question;
import com.zjut.noStopStudy.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDao questionDao;

    @Override
    public List<Question> findAll(Sort sort) {
        return questionDao.findAll(sort);
    }

    @Override
    public Page<Question> findAll(Pageable pageable) {
        return questionDao.findAll(pageable);
    }

    @Override
    public Question save(Question question) {
        return questionDao.save(question);
    }
}
