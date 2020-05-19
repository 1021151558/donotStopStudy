package com.zjut.noStopStudy.service.impl;

import com.zjut.noStopStudy.dao.TeachingSituationDao;
import com.zjut.noStopStudy.model.TeachingSituation;
import com.zjut.noStopStudy.model.modelUtil.TeachingSituationId;
import com.zjut.noStopStudy.service.TeachingSituationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TeachingSituationServiceImpl implements TeachingSituationService {

    @Autowired
    private TeachingSituationDao teachingSituationDao;

    @Override
    public TeachingSituation save(TeachingSituation teachingSituation) {
        return teachingSituationDao.save(teachingSituation);
    }

    @Override
    public Page<TeachingSituation> findAll(Pageable pageable) {
        return teachingSituationDao.findAll(pageable);
    }

    @Override
    public TeachingSituation findByTeachingSituationId(TeachingSituationId teachingSituationId) {
        return teachingSituationDao.findById(teachingSituationId).get();
    }

    @Override
    public void deleteByTeachingSituationId(TeachingSituationId teachingSituationId) {
        teachingSituationDao.deleteById(teachingSituationId);
    }
}
