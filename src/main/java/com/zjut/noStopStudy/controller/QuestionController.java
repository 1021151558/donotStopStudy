package com.zjut.noStopStudy.controller;

import com.zjut.noStopStudy.VO.AjaxResult;
import com.zjut.noStopStudy.convert.ListToPage;
import com.zjut.noStopStudy.model.Question;
import com.zjut.noStopStudy.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;


    @RequestMapping(value = "/question/findAll/{page}/{size}", method = RequestMethod.GET)
    public AjaxResult refreshQuestion(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        System.out.println("refreshQuestion");
        Sort sort = Sort.by(Sort.Direction.DESC,"createTime");
        PageRequest request = PageRequest.of(page,size,sort);
        Page<Question> questionList = questionService.findAll(request);
        if (questionList == null) {
            return null;
        } else
            return AjaxResult.success(questionList);
    }


    @RequestMapping(value = "/question/save", method = RequestMethod.POST)
    public AjaxResult saveQuestion(@RequestBody Question question) {

        questionService.save(question);
        return AjaxResult.success();
    }
}
