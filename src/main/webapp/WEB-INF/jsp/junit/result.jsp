<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.maistruk.model.junit.*"%>
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
	    List<JunitQuestionAnswer> questionAnswerList = (ArrayList<JunitQuestionAnswer>) session.getAttribute("junitQuestionAnswerList");
			int questionAmount = questionAnswerList.size();
			List<JunitAnswerFlags> answerFlagsList = (ArrayList<JunitAnswerFlags>) session.getAttribute("junitAnswerFlagsList");
			int rightAnswerAmout = 0;
			for(JunitAnswerFlags answerFlags : answerFlagsList){
			    if(answerFlags.checkAnswer()){
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
					for(JunitQuestionAnswer questionAnswer : questionAnswerList){
					    JunitAnswerFlags answerFlags = answerFlagsList.get(questionNum);
					    questionNum++;
					    out.write(" <div class = \"questionBox\">"+ questionNum + ": " + questionAnswer.getQuestion().getQuestion() + "</div><br>");
					    if(questionAnswer.getAnswer1().getFlag()){
					    	out.write("<div class = \"answerTextRight\">" + questionAnswer.getAnswer1().getAnswer() + "</div><br>");
					    }else{
					        out.write("<div class = \"answerText\">" + questionAnswer.getAnswer1().getAnswer() + "</div><br>");
					    }
					    if(questionAnswer.getAnswer2().getFlag()){
					    	out.write("<div class = \"answerTextRight\">" + questionAnswer.getAnswer2().getAnswer() + "</div><br>");
					    }else{
						    out.write("<div class = \"answerText\">" + questionAnswer.getAnswer2().getAnswer() + "</div><br>");
					    }
					    if(questionAnswer.getAnswer3().getFlag()){
					   		out.write("<div class = \"answerTextRight\">" + questionAnswer.getAnswer3().getAnswer() + "</div><br>");
					    }else{
					   		out.write("<div class = \"answerText\">" + questionAnswer.getAnswer3().getAnswer() + "</div><br>");
					    }
					    if(questionAnswer.getAnswer4().getFlag()){
						    out.write("<div class = \"answerTextRight\">" + questionAnswer.getAnswer4().getAnswer() + "</div><br>");
					    }else{
						    out.write("<div class = \"answerText\">" + questionAnswer.getAnswer4().getAnswer() + "</div><br>");

					    }
		%>
	    <p class= "myAnswer">Your answer:
	    <%
	    if(answerFlags.getMyAnswerFlag1()){
	        out.println(questionAnswer.getAnswer1().getAnswer());
	    }
	    if(answerFlags.getMyAnswerFlag2()){
	        out.println(questionAnswer.getAnswer2().getAnswer());
	    }
	    if(answerFlags.getMyAnswerFlag3()){
	        out.println(questionAnswer.getAnswer3().getAnswer());
	    }
	    if(answerFlags.getMyAnswerFlag4()){
	        out.println(questionAnswer.getAnswer4().getAnswer());
	    }
	    out.println("</p>");
	    out.println("<hr width=\"75%\" color=\"#ff0000\" size=\"4\"/>");
	}
	%>
	
</body>
</html>