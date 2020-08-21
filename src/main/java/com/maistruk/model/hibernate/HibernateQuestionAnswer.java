package com.maistruk.model.hibernate;

public class HibernateQuestionAnswer {

    private HibernateQuestion question;
    private HibernateAnswer answer1;
    private HibernateAnswer answer2;
    private HibernateAnswer answer3;
    private HibernateAnswer answer4;

    public HibernateQuestion getQuestion() {
        return question;
    }

    public void setQuestion(HibernateQuestion question) {
        this.question = question;
    }

    public HibernateAnswer getAnswer1() {
        return answer1;
    }

    public void setAnswer1(HibernateAnswer answer1) {
        this.answer1 = answer1;
    }

    public HibernateAnswer getAnswer2() {
        return answer2;
    }

    public void setAnswer2(HibernateAnswer answer2) {
        this.answer2 = answer2;
    }

    public HibernateAnswer getAnswer3() {
        return answer3;
    }

    public void setAnswer3(HibernateAnswer answer3) {
        this.answer3 = answer3;
    }

    public HibernateAnswer getAnswer4() {
        return answer4;
    }

    public void setAnswer4(HibernateAnswer answer4) {
        this.answer4 = answer4;
    }

    @Override
    public String toString() {
        return "HibernateQuestionAnswer [question=" + question + ", answer1=" + answer1 + ", answer2=" + answer2
                + ", answer3=" + answer3 + ", answer4=" + answer4 + "]";
    }

}
