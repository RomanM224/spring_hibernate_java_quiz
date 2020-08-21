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


import com.maistruk.model.junit.JunitAnswerFlags;
import com.maistruk.model.junit.JunitQuestionAnswer;
import com.maistruk.service.junit.JunitManager;

@Controller
public class JunitController {
    
    @Autowired
    private JunitManager manager;
    
    @RequestMapping(value = "/junitStart", method = RequestMethod.POST)
    public ModelAndView startQuiz(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("junit/question.jsp");
        JunitQuestionAnswer questionAnswer = manager.genereteQuestion();
        JunitAnswerFlags  answerFlags = new JunitAnswerFlags();
        answerFlags.setFlags(questionAnswer);
        
        List<JunitQuestionAnswer> questionAnswerList = new ArrayList<>();
        questionAnswerList.add(questionAnswer);
        List<JunitAnswerFlags> answerFlagsList = new ArrayList<>();
        answerFlagsList.add(answerFlags);
        
        session.setAttribute("junitQuestionAnswerList", questionAnswerList);
        session.setAttribute("junitAnswerFlagsList", answerFlagsList);

        return modelAndView;
    }
    
    @RequestMapping(value = "/junitNextQuestion", method = RequestMethod.POST)
    public ModelAndView nextQuestion(HttpSession session, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        List<JunitAnswerFlags> answerFlagsList = (ArrayList<JunitAnswerFlags>) session.getAttribute("junitAnswerFlagsList");
        JunitAnswerFlags answerFlags = answerFlagsList.get(answerFlagsList.size() - 1);
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
        List<JunitQuestionAnswer> questionAnswerList = (ArrayList<JunitQuestionAnswer>) session.getAttribute("junitQuestionAnswerList");
        if(questionAnswerList.size() < 15) {
            JunitQuestionAnswer questionAnswer = manager.genereteUniqueQuestion(questionAnswerList);
            answerFlags = new JunitAnswerFlags();
            answerFlags.setFlags(questionAnswer);
            questionAnswerList.add(questionAnswer);
            answerFlagsList.add(answerFlags);
//            session.setAttribute("springQuestionAnswerList", springQuestionAnswerList);
//            session.setAttribute("springAnswerFlagsList", springAnswerFlagsList);
            modelAndView.setViewName("junit/question.jsp");
        } else {
            modelAndView.setViewName("junit/result.jsp");
        }
        return modelAndView;
    }

}
