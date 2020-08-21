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

import com.maistruk.model.servlet.ServletAnswerFlags;
import com.maistruk.model.servlet.ServletQuestionAnswer;
import com.maistruk.service.servlet.ServletManager;

@Controller
public class ServletController {
    
    @Autowired
    private ServletManager manager;

    @RequestMapping(value = "/servletStart", method = RequestMethod.POST)
    public ModelAndView startQuiz(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("servlet/question.jsp");
        ServletQuestionAnswer questionAnswer = manager.genereteQuestion();
        ServletAnswerFlags  answerFlags = new ServletAnswerFlags();
        answerFlags.setFlags(questionAnswer);
        
        List<ServletQuestionAnswer> questionAnswerList = new ArrayList<>();
        questionAnswerList.add(questionAnswer);
        List<ServletAnswerFlags> answerFlagsList = new ArrayList<>();
        answerFlagsList.add(answerFlags);
        
        session.setAttribute("servletQuestionAnswerList", questionAnswerList);
        session.setAttribute("servletAnswerFlagsList", answerFlagsList);

        return modelAndView;
    }
    
    @RequestMapping(value = "/servletNextQuestion", method = RequestMethod.POST)
    public ModelAndView nextQuestion(HttpSession session, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        List<ServletAnswerFlags> answerFlagsList = (ArrayList<ServletAnswerFlags>) session.getAttribute("servletAnswerFlagsList");
        ServletAnswerFlags answerFlags = answerFlagsList.get(answerFlagsList.size() - 1);
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
        List<ServletQuestionAnswer> questionAnswerList = (ArrayList<ServletQuestionAnswer>) session.getAttribute("servletQuestionAnswerList");
        if(questionAnswerList.size() < 15) {
            ServletQuestionAnswer questionAnswer = manager.genereteUniqueQuestion(questionAnswerList);
            answerFlags = new ServletAnswerFlags();
            answerFlags.setFlags(questionAnswer);
            questionAnswerList.add(questionAnswer);
            answerFlagsList.add(answerFlags);
//            session.setAttribute("springQuestionAnswerList", springQuestionAnswerList);
//            session.setAttribute("springAnswerFlagsList", springAnswerFlagsList);
            modelAndView.setViewName("servlet/question.jsp");
        } else {
            modelAndView.setViewName("servlet/result.jsp");
        }
        return modelAndView;
    }
}
