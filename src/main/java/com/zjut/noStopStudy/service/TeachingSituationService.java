package com.zjut.noStopStudy.service;

import com.zjut.noStopStudy.model.TeachingSituation;
import com.zjut.noStopStudy.model.modelUtil.TeachingSituationId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TeachingSituationService {

    TeachingSituation save(TeachingSituation teachingSituation);

    Page<TeachingSituation> findAll(Pageable pageable);

    TeachingSituation findByTeachingSituationId(TeachingSituationId teachingSituationId);

    void deleteByTeachingSituationId(TeachingSituationId teachingSituationId);
}
