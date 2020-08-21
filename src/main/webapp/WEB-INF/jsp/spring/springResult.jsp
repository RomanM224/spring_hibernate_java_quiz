<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.maistruk.model.spring.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
      <link href="resources/css/resultStyles.css" rel="stylesheet" type="text/css">

</head>
<body>
	<form action="/spring_hibernate_java_quiz" >
		<input type="submit" value = "Home" class = "home_button">
	</form>
	<%
	    List<SpringQuestionAnswer> springQuestionAnswerList = (ArrayList<SpringQuestionAnswer>) session.getAttribute("springQuestionAnswerList");
			int questionAmount = springQuestionAnswerList.size();
			List<SpringAnswerFlags> springAnswerFlagsList = (ArrayList<SpringAnswerFlags>) session.getAttribute("springAnswerFlagsList");
			int rightAnswerAmout = 0;
			for(SpringAnswerFlags springAnswerFlags : springAnswerFlagsList){
			    if(springAnswerFlags.checkAnswer()){
			        rightAnswerAmout++;
			    }
			}
	%>
		<p id="scoreNumGreen">Your Score:<span id="scoreNumRed"><%
		    out.println(rightAnswerAmout);
		%></span>/<%
		    out.println(questionAmount);
		%></p>
	
	<%
		    int questionNum = 0;
					for(SpringQuestionAnswer springQuestionAnswer : springQuestionAnswerList){
					    SpringAnswerFlags springAnswerFlags = springAnswerFlagsList.get(questionNum);
					    questionNum++;
					    out.write(" <div class = \"questionBox\">"+ questionNum + ": " + springQuestionAnswer.getSpringQuestion().getQuestion() + "</div><br>");
					    if(springQuestionAnswer.getSpringAnswer1().getFlag()){
					    	out.write("<div class = \"answerTextRight\">" + springQuestionAnswer.getSpringAnswer1().getAnswer() + "</div><br>");
					    }else{
					        out.write("<div class = \"answerText\">" + springQuestionAnswer.getSpringAnswer1().getAnswer() + "</div><br>");
					    }
					    if(springQuestionAnswer.getSpringAnswer2().getFlag()){
					    	out.write("<div class = \"answerTextRight\">" + springQuestionAnswer.getSpringAnswer2().getAnswer() + "</div><br>");
					    }else{
						    out.write("<div class = \"answerText\">" + springQuestionAnswer.getSpringAnswer2().getAnswer() + "</div><br>");
					    }
					    if(springQuestionAnswer.getSpringAnswer3().getFlag()){
					   		out.write("<div class = \"answerTextRight\">" + springQuestionAnswer.getSpringAnswer3().getAnswer() + "</div><br>");
					    }else{
					   		out.write("<div class = \"answerText\">" + springQuestionAnswer.getSpringAnswer3().getAnswer() + "</div><br>");
					    }
					    if(springQuestionAnswer.getSpringAnswer4().getFlag()){
						    out.write("<div class = \"answerTextRight\">" + springQuestionAnswer.getSpringAnswer4().getAnswer() + "</div><br>");
					    }else{
						    out.write("<div class = \"answerText\">" + springQuestionAnswer.getSpringAnswer4().getAnswer() + "</div><br>");

					    }
		%>
	    <p class= "myAnswer">Your answer:
	    <%
	    if(springAnswerFlags.getMyAnswerFlag1()){
	        out.println(springQuestionAnswer.getSpringAnswer1().getAnswer());
	    }
	    if(springAnswerFlags.getMyAnswerFlag2()){
	        out.println(springQuestionAnswer.getSpringAnswer2().getAnswer());
	    }
	    if(springAnswerFlags.getMyAnswerFlag3()){
	        out.println(springQuestionAnswer.getSpringAnswer3().getAnswer());
	    }
	    if(springAnswerFlags.getMyAnswerFlag4()){
	        out.println(springQuestionAnswer.getSpringAnswer4().getAnswer());
	    }
	    out.println("</p>");
	    out.println("<hr width=\"75%\" color=\"#ff0000\" size=\"4\"/>");
	}
	%>
	
</body>
</html>