package com.maistruk.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.maistruk.model.hibernate.HibernateAnswerFlags;
import com.maistruk.model.hibernate.HibernateQuestionAnswer;
import com.maistruk.service.hibernate.HibernateManager;

@Controller
public class HibernateController {
    
    @Autowired
    private HibernateManager manager;
    
    @RequestMapping(value = "/hibernateStart", method = RequestMethod.POST)
    public ModelAndView startQuiz(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hibernate/question.jsp");
        HibernateQuestionAnswer questionAnswer = manager.genereteQuestion();
        HibernateAnswerFlags  answerFlags = new HibernateAnswerFlags();
        answerFlags.setFlags(questionAnswer);
        
        List<HibernateQuestionAnswer> questionAnswerList = new ArrayList<>();
        questionAnswerList.add(questionAnswer);
        List<HibernateAnswerFlags> answerFlagsList = new ArrayList<>();
        answerFlagsList.add(answerFlags);
        
        session.setAttribute("hibernateQuestionAnswerList", questionAnswerList);
        session.setAttribute("hibernateAnswerFlagsList", answerFlagsList);

        return modelAndView;
    }
    
    @RequestMapping(value = "/hibernateNextQuestion", method = RequestMethod.POST)
    public ModelAndView nextQuestion(HttpSession session, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        List<HibernateAnswerFlags> answerFlagsList = (ArrayList<HibernateAnswerFlags>) session.getAttribute("hibernateAnswerFlagsList");
        HibernateAnswerFlags answerFlags = answerFlagsList.get(answerFlagsList.size() - 1);
        if(request.getParameter("answer1") != null) {
            answerFlags.setMyAnswerFlag1(true);
        } else {
            answerFlags.setMyAnswerFlag1(false);
        }
        
        if(request.getParameter("answer2") != null) {
            answerFlags.setMyAnswerFlag2(true);
        } else {
            answerFlags.setMyAnswerFlag2(false);
        }
        
        if(request.getParameter("answer3") != null) {
            answerFlags.setMyAnswerFlag3(true);
        } else {
            answerFlags.setMyAnswerFlag3(false);
        }
        
        if(request.getParameter("answer4") != null) {
            answerFlags.setMyAnswerFlag4(true);
        } else {
            answerFlags.setMyAnswerFlag4(false);
        }
        System.out.println(answerFlagsList);
        List<HibernateQuestionAnswer> questionAnswerList = (ArrayList<HibernateQuestionAnswer>) session.getAttribute("hibernateQuestionAnswerList");
        if(questionAnswerList.size() < 15) {
            HibernateQuestionAnswer questionAnswer = manager.genereteUniqueQuestion(questionAnswerList);
            answerFlags = new HibernateAnswerFlags();
            answerFlags.setFlags(questionAnswer);
            questionAnswerList.add(questionAnswer);
            answerFlagsList.add(answerFlags);
//            session.setAttribute("springQuestionAnswerList", springQuestionAnswerList);
//            session.setAttribute("springAnswerFlagsList", springAnswerFlagsList);
            modelAndView.setViewName("hibernate/question.jsp");
        } else {
            modelAndView.setViewName("hibernate/result.jsp");
        }
        return modelAndView;
    }

}
