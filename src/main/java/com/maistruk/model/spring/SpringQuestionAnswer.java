package com.maistruk.model.spring;

public class SpringQuestionAnswer {

    private SpringQuestion springQuestion;
    private SpringAnswer springAnswer1;
    private SpringAnswer springAnswer2;
    private SpringAnswer springAnswer3;
    private SpringAnswer springAnswer4;

    public SpringQuestion getSpringQuestion() {
        return springQuestion;
    }

    public void setSpringQuestion(SpringQuestion springQuestion) {
        this.springQuestion = springQuestion;
    }

    public SpringAnswer getSpringAnswer1() {
        return springAnswer1;
    }

    public void setSpringAnswer1(SpringAnswer springAnswer1) {
        this.springAnswer1 = springAnswer1;
    }

    public SpringAnswer getSpringAnswer2() {
        return springAnswer2;
    }

    public void setSpringAnswer2(SpringAnswer springAnswer2) {
        this.springAnswer2 = springAnswer2;
    }

    public SpringAnswer getSpringAnswer3() {
        return springAnswer3;
    }

    public void setSpringAnswer3(SpringAnswer springAnswer3) {
        this.springAnswer3 = springAnswer3;
    }

    public SpringAnswer getSpringAnswer4() {
        return springAnswer4;
    }

    public void setSpringAnswer4(SpringAnswer springAnswer4) {
        this.springAnswer4 = springAnswer4;
    }

    @Override
    public String toString() {
        return "SpringQuestionAnswer [springQuestion=" + springQuestion + ", springAnswer1=" + springAnswer1
                + ", springAnswer2=" + springAnswer2 + ", springAnswer3=" + springAnswer3 + ", springAnswer4="
                + springAnswer4 + "]";
    }

}
