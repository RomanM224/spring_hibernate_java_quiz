package com.maistruk.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.maistruk.model.spring.SpringAnswerFlags;
import com.maistruk.model.spring.SpringQuestionAnswer;
import com.maistruk.service.spring.SpringManager;

@Controller
public class SpringController {
    
    @Autowired
    private SpringManager springManager;
    
    @RequestMapping(value = "/springStart", method = RequestMethod.POST)
    public ModelAndView startQuiz(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("spring/springQuestion.jsp");
        SpringQuestionAnswer springQuestionAnswer = springManager.genereteQuestion();
        SpringAnswerFlags  springAnswerFlags = new SpringAnswerFlags();
        springAnswerFlags.setFlags(springQuestionAnswer);
        
        List<SpringQuestionAnswer> springQuestionAnswerList = new ArrayList<>();
        springQuestionAnswerList.add(springQuestionAnswer);
        List<SpringAnswerFlags> springAnswerFlagsList = new ArrayList<>();
        springAnswerFlagsList.add(springAnswerFlags);
        
        session.setAttribute("springQuestionAnswerList", springQuestionAnswerList);
        session.setAttribute("springAnswerFlagsList", springAnswerFlagsList);
//        modelAndView.addObject("springQuestionAnswerList", springQuestionAnswerList);
//        modelAndView.addObject("springAnswerFlagsList", springAnswerFlagsList);
        return modelAndView;
    }
    
    @RequestMapping(value = "/springNextQuestion", method = RequestMethod.POST)
    public ModelAndView nextQuestion(HttpSession session, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        List<SpringAnswerFlags> springAnswerFlagsList = (ArrayList<SpringAnswerFlags>) session.getAttribute("springAnswerFlagsList");
        SpringAnswerFlags springAnswerFlags = springAnswerFlagsList.get(springAnswerFlagsList.size() - 1);
        if(request.getParameter("answer1") != null) {
            springAnswerFlags.setMyAnswerFlag1(true);
        } else {
            springAnswerFlags.setMyAnswerFlag1(false);
        }
        
        if(request.getParameter("answer2") != null) {
            springAnswerFlags.setMyAnswerFlag2(true);
        } else {
            springAnswerFlags.setMyAnswerFlag2(false);
        }
        
        if(request.getParameter("answer3") != null) {
            springAnswerFlags.setMyAnswerFlag3(true);
        } else {
            springAnswerFlags.setMyAnswerFlag3(false);
        }
        
        if(request.getParameter("answer4") != null) {
            springAnswerFlags.setMyAnswerFlag4(true);
        } else {
            springAnswerFlags.setMyAnswerFlag4(false);
        }
        System.out.println(springAnswerFlagsList);
        List<SpringQuestionAnswer> springQuestionAnswerList = (ArrayList<SpringQuestionAnswer>) session.getAttribute("springQuestionAnswerList");
        if(springQuestionAnswerList.size() < 15) {
            SpringQuestionAnswer springQuestionAnswer = springManager.genereteUniqueQuestion(springQuestionAnswerList);
            springAnswerFlags = new SpringAnswerFlags();
            springAnswerFlags.setFlags(springQuestionAnswer);
            springQuestionAnswerList.add(springQuestionAnswer);
            springAnswerFlagsList.add(springAnswerFlags);
//            session.setAttribute("springQuestionAnswerList", springQuestionAnswerList);
//            session.setAttribute("springAnswerFlagsList", springAnswerFlagsList);
            modelAndView.setViewName("spring/springQuestion.jsp");
        } else {
            modelAndView.setViewName("spring/springResult.jsp");
        }
        
        return modelAndView;
    }
    
    @RequestMapping(value = "/springResult")
    public String result() {
        return "spring/springResult.jsp";
    }

}
