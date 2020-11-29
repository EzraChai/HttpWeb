<%@ page import="java.util.List,com.Entity.Question" %>

<body>
<center>
    <form action="/Exam/score">
    <table border="2">
    <tr>
    <td> Question ID </td>
    <td> Title </td>
    <td> A </td>
    <td> B </td>
    <td> C </td>
    <td> D </td>
    <td> Answer </td>
    <tr>

    <%
        List<Question> questionList = (List)session.getAttribute("question");
        for(Question question : questionList){
    %>
        <tr>
            <td><%=question.getQuestionId()%></td>
            <td><%=question.getTitle()%></td>
            <td><%=question.getOptionA()%></td>
            <td><%=question.getOptionB()%></td>
            <td><%=question.getOptionC()%></td>
            <td><%=question.getOptionD()%></td>
            <td>
                <input type="radio" name="answer_<%=question.getQuestionId()%>" value="A">A
                <input type="radio" name="answer_<%=question.getQuestionId()%>" value="B">B
                <input type="radio" name="answer_<%=question.getQuestionId()%>" value="C">C
                <input type="radio" name="answer_<%=question.getQuestionId()%>" value="D">D
            </td>
        <tr>
    <%
        }
    %>
    <tr align="center">
        <td colspan="2"><input type="submit" value="Submit Answer"></td>
        <td colspan="5"><input type="reset" value="Reset Answer"></td>
    </tr>
    </table>
    <form>
</center>
</body>