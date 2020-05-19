package com.zjut.noStopStudy.dao;

import com.zjut.noStopStudy.model.TeachingSituation;
import com.zjut.noStopStudy.model.modelUtil.TeachingSituationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachingSituationDao extends JpaRepository<TeachingSituation, TeachingSituationId> {


}
