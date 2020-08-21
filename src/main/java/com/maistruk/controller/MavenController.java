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

import com.maistruk.model.maven.MavenAnswerFlags;
import com.maistruk.model.maven.MavenQuestionAnswer;
import com.maistruk.service.maven.MavenManager;

@Controller
public class MavenController {
    
    @Autowired
    private MavenManager manager;
    
    @RequestMapping(value = "/mavenStart", method = RequestMethod.POST)
    public ModelAndView startQuiz(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("maven/question.jsp");
        MavenQuestionAnswer questionAnswer = manager.genereteQuestion();
        MavenAnswerFlags  answerFlags = new MavenAnswerFlags();
        answerFlags.setFlags(questionAnswer);
        
        List<MavenQuestionAnswer> questionAnswerList = new ArrayList<>();
        questionAnswerList.add(questionAnswer);
        List<MavenAnswerFlags> answerFlagsList = new ArrayList<>();
        answerFlagsList.add(answerFlags);
        
        session.setAttribute("mavenQuestionAnswerList", questionAnswerList);
        session.setAttribute("mavenAnswerFlagsList", answerFlagsList);

        return modelAndView;
    }
    
    @RequestMapping(value = "/mavenNextQuestion", method = RequestMethod.POST)
    public ModelAndView nextQuestion(HttpSession session, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        List<MavenAnswerFlags> answerFlagsList = (ArrayList<MavenAnswerFlags>) session.getAttribute("mavenAnswerFlagsList");
        MavenAnswerFlags answerFlags = answerFlagsList.get(answerFlagsList.size() - 1);
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
        List<MavenQuestionAnswer> questionAnswerList = (ArrayList<MavenQuestionAnswer>) session.getAttribute("mavenQuestionAnswerList");
        if(questionAnswerList.size() < 15) {
            MavenQuestionAnswer questionAnswer = manager.genereteUniqueQuestion(questionAnswerList);
            answerFlags = new MavenAnswerFlags();
            answerFlags.setFlags(questionAnswer);
            questionAnswerList.add(questionAnswer);
            answerFlagsList.add(answerFlags);
//            session.setAttribute("springQuestionAnswerList", springQuestionAnswerList);
//            session.setAttribute("springAnswerFlagsList", springAnswerFlagsList);
            modelAndView.setViewName("maven/question.jsp");
        } else {
            modelAndView.setViewName("maven/result.jsp");
        }
        return modelAndView;
    }

}
