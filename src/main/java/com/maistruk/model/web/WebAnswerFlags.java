package com.maistruk.model.web;


public class WebAnswerFlags {
    
    private Integer id;
    private Boolean answerFlag1;
    private Boolean answerFlag2;
    private Boolean answerFlag3;
    private Boolean answerFlag4;

    private Boolean myAnswerFlag1;
    private Boolean myAnswerFlag2;
    private Boolean myAnswerFlag3;
    private Boolean myAnswerFlag4;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getAnswerFlag1() {
        return answerFlag1;
    }

    public void setAnswerFlag1(Boolean answerFlag1) {
        this.answerFlag1 = answerFlag1;
    }

    public Boolean getAnswerFlag2() {
        return answerFlag2;
    }

    public void setAnswerFlag2(Boolean answerFlag2) {
        this.answerFlag2 = answerFlag2;
    }

    public Boolean getAnswerFlag3() {
        return answerFlag3;
    }

    public void setAnswerFlag3(Boolean answerFlag3) {
        this.answerFlag3 = answerFlag3;
    }

    public Boolean getAnswerFlag4() {
        return answerFlag4;
    }

    public void setAnswerFlag4(Boolean answerFlag4) {
        this.answerFlag4 = answerFlag4;
    }

    public Boolean getMyAnswerFlag1() {
        return myAnswerFlag1;
    }

    public void setMyAnswerFlag1(Boolean myAnswerFlag1) {
        this.myAnswerFlag1 = myAnswerFlag1;
    }

    public Boolean getMyAnswerFlag2() {
        return myAnswerFlag2;
    }

    public void setMyAnswerFlag2(Boolean myAnswerFlag2) {
        this.myAnswerFlag2 = myAnswerFlag2;
    }

    public Boolean getMyAnswerFlag3() {
        return myAnswerFlag3;
    }

    public void setMyAnswerFlag3(Boolean myAnswerFlag3) {
        this.myAnswerFlag3 = myAnswerFlag3;
    }

    public Boolean getMyAnswerFlag4() {
        return myAnswerFlag4;
    }

    public void setMyAnswerFlag4(Boolean myAnswerFlag4) {
        this.myAnswerFlag4 = myAnswerFlag4;
    }

    

    @Override
    public String toString() {
        return "WebAnswerFlags [id=" + id + ", answerFlag1=" + answerFlag1 + ", answerFlag2=" + answerFlag2
                + ", answerFlag3=" + answerFlag3 + ", answerFlag4=" + answerFlag4 + ", myAnswerFlag1=" + myAnswerFlag1
                + ", myAnswerFlag2=" + myAnswerFlag2 + ", myAnswerFlag3=" + myAnswerFlag3 + ", myAnswerFlag4="
                + myAnswerFlag4 + "]";
    }

    public Boolean checkAnswer() {
        if (answerFlag1 != myAnswerFlag1) {
            return false;
        }
        if (answerFlag2 != myAnswerFlag2) {
            return false;
        }
        if (answerFlag3 != myAnswerFlag3) {
            return false;
        }
        if (answerFlag4 != myAnswerFlag4) {
            return false;
        }
        return true;
    }

    public void setFlags(WebQuestionAnswer questionAnswer) {
        id = questionAnswer.getQuestion().getId();
        answerFlag1 = questionAnswer.getAnswer1().getFlag();
        answerFlag2 = questionAnswer.getAnswer2().getFlag();
        answerFlag3 = questionAnswer.getAnswer3().getFlag();
        answerFlag4 = questionAnswer.getAnswer4().getFlag();
    }

}
