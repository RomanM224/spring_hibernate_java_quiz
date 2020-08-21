package com.maistruk.model.java_core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "java_core_question")
public class JavaCoreQuestion {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
   // @Column(name = "id", updatable = false, nullable = false)
    private Integer id;
    
   // @Column(length = 700)
    @Column(columnDefinition = "TEXT")
    private String question;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "JavaCoreQuestion [id=" + id + ", question=" + question + "]";
    }
    

}
