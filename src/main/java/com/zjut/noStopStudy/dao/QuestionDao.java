package com.zjut.noStopStudy.dao;

import com.zjut.noStopStudy.model.Question;
import com.zjut.noStopStudy.model.modelUtil.QuestionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDao extends JpaRepository<Question, QuestionId> {

}
