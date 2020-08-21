package com.maistruk.model.sql;

public class SqlQuestionAnswer {

    private SqlQuestion question;
    private SqlAnswer answer1;
    private SqlAnswer answer2;
    private SqlAnswer answer3;
    private SqlAnswer answer4;

    public SqlQuestion getQuestion() {
        return question;
    }

    public void setQuestion(SqlQuestion question) {
        this.question = question;
    }

    public SqlAnswer getAnswer1() {
        return answer1;
    }

    public void setAnswer1(SqlAnswer answer1) {
        this.answer1 = answer1;
    }

    public SqlAnswer getAnswer2() {
        return answer2;
    }

    public void setAnswer2(SqlAnswer answer2) {
        this.answer2 = answer2;
    }

    public SqlAnswer getAnswer3() {
        return answer3;
    }

    public void setAnswer3(SqlAnswer answer3) {
        this.answer3 = answer3;
    }

    public SqlAnswer getAnswer4() {
        return answer4;
    }

    public void setAnswer4(SqlAnswer answer4) {
        this.answer4 = answer4;
    }

    @Override
    public String toString() {
        return "SqlQuestionAnswer [question=" + question + ", answer1=" + answer1 + ", answer2=" + answer2
                + ", answer3=" + answer3 + ", answer4=" + answer4 + "]";
    }

}
