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

import com.maistruk.model.java_core.JavaCoreAnswerFlags;
import com.maistruk.model.java_core.JavaCoreQuestionAnswer;
import com.maistruk.model.spring.SpringAnswerFlags;
import com.maistruk.model.spring.SpringQuestionAnswer;
import com.maistruk.service.java_core.JavaCoreManager;

@Controller
public class JavaCoreController {
    
    @Autowired
    private JavaCoreManager manager;
    
    @RequestMapping(value = "/javaCoreStart", method = RequestMethod.POST)
    public ModelAndView startQuiz(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("javaCore/JavaCoreQuestion.jsp");
        JavaCoreQuestionAnswer questionAnswer = manager.genereteQuestion();
        JavaCoreAnswerFlags  answerFlags = new JavaCoreAnswerFlags();
        answerFlags.setFlags(questionAnswer);
        
        List<JavaCoreQuestionAnswer> questionAnswerList = new ArrayList<>();
        questionAnswerList.add(questionAnswer);
        List<JavaCoreAnswerFlags> answerFlagsList = new ArrayList<>();
        answerFlagsList.add(answerFlags);
        
        session.setAttribute("javaCoreQuestionAnswerList", questionAnswerList);
        session.setAttribute("javaCoreAnswerFlagsList", answerFlagsList);

        return modelAndView;
    }
    
    @RequestMapping(value = "/javaCoreNextQuestion", method = RequestMethod.POST)
    public ModelAndView nextQuestion(HttpSession session, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        List<JavaCoreAnswerFlags> answerFlagsList = (ArrayList<JavaCoreAnswerFlags>) session.getAttribute("javaCoreAnswerFlagsList");
        JavaCoreAnswerFlags answerFlags = answerFlagsList.get(answerFlagsList.size() - 1);
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
        List<JavaCoreQuestionAnswer> questionAnswerList = (ArrayList<JavaCoreQuestionAnswer>) session.getAttribute("javaCoreQuestionAnswerList");
        if(questionAnswerList.size() < 15) {
            JavaCoreQuestionAnswer questionAnswer = manager.genereteUniqueQuestion(questionAnswerList);
            answerFlags = new JavaCoreAnswerFlags();
            answerFlags.setFlags(questionAnswer);
            questionAnswerList.add(questionAnswer);
            answerFlagsList.add(answerFlags);
//            session.setAttribute("springQuestionAnswerList", springQuestionAnswerList);
//            session.setAttribute("springAnswerFlagsList", springAnswerFlagsList);
            modelAndView.setViewName("javaCore/JavaCoreQuestion.jsp");
        } else {
            modelAndView.setViewName("javaCore/JavaCoreResult.jsp");
        }
        
        return modelAndView;
    }
    
    @RequestMapping(value = "/javaCoreResult")
    public String result() {
        return "javaCore/javaCoreResult.jsp";
    }

}
