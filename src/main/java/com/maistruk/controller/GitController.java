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

import com.maistruk.model.git.GitAnswerFlags;
import com.maistruk.model.git.GitQuestionAnswer;
import com.maistruk.service.git.GitManager;

@Controller
public class GitController {
    
    @Autowired
    private GitManager manager;
    
    @RequestMapping(value = "/gitStart", method = RequestMethod.POST)
    public ModelAndView startQuiz(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("git/question.jsp");
        GitQuestionAnswer questionAnswer = manager.genereteQuestion();
        GitAnswerFlags  answerFlags = new GitAnswerFlags();
        answerFlags.setFlags(questionAnswer);
        
        List<GitQuestionAnswer> questionAnswerList = new ArrayList<>();
        questionAnswerList.add(questionAnswer);
        List<GitAnswerFlags> answerFlagsList = new ArrayList<>();
        answerFlagsList.add(answerFlags);
        
        session.setAttribute("gitQuestionAnswerList", questionAnswerList);
        session.setAttribute("gitAnswerFlagsList", answerFlagsList);

        return modelAndView;
    }
    
    @RequestMapping(value = "/gitNextQuestion", method = RequestMethod.POST)
    public ModelAndView nextQuestion(HttpSession session, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        List<GitAnswerFlags> answerFlagsList = (ArrayList<GitAnswerFlags>) session.getAttribute("gitAnswerFlagsList");
        GitAnswerFlags answerFlags = answerFlagsList.get(answerFlagsList.size() - 1);
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
        List<GitQuestionAnswer> questionAnswerList = (ArrayList<GitQuestionAnswer>) session.getAttribute("gitQuestionAnswerList");
        if(questionAnswerList.size() < 15) {
            GitQuestionAnswer questionAnswer = manager.genereteUniqueQuestion(questionAnswerList);
            answerFlags = new GitAnswerFlags();
            answerFlags.setFlags(questionAnswer);
            questionAnswerList.add(questionAnswer);
            answerFlagsList.add(answerFlags);
//            session.setAttribute("springQuestionAnswerList", springQuestionAnswerList);
//            session.setAttribute("springAnswerFlagsList", springAnswerFlagsList);
            modelAndView.setViewName("git/question.jsp");
        } else {
            modelAndView.setViewName("git/result.jsp");
        }
        
        return modelAndView;
    }
    
//    @RequestMapping(value = "/gitResult")
//    public String result() {
//        return "git/result.jsp";
//    }

}
