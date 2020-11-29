<%@ page import="javax.servlet.http.HttpServletRequest,com.Entity.Question" %>
<%@ page isELIgnored="false" %>

<html>
    <body>
        <center>
                <form action="/Exam/question/update" method="get">

                    <table border="2">
                        <tr>
                            <td>Question ID</td>
                            <td><input type="text" name="questionId" value="${requestScope.key.questionId}" readOnly></td>
                        </tr>
                        <tr>
                            <td>Title</td>
                            <td><input type="text" name="title" value="${requestScope.key.title}"></td>
                        </tr>
                        <tr>
                            <td>A:</td>
                            <td><input type="text" name="optionA" value="${requestScope.key.optionA}"></td>
                        </tr>
                        <tr>
                            <td>B:</td>
                            <td><input type="text" name="optionB" value="${requestScope.key.optionB}"></td>
                        </tr>
                        <tr>
                        <td>C:</td>
                        <td><input type="text" name="optionC" value="${requestScope.key.optionC}"></td>
                        </tr>
                        <tr>
                        <td>D:</td>
                            <td><input type="text" name="optionD" value="${requestScope.key.optionD}"></td>
                        </tr>
                        <tr>
                            <td>Answer:</td>
                            <td><input type="radio" name="answer" value="A" ${"A" eq key.answer?"checked":""}>A
                                <input type="radio" name="answer" value="B" ${"B" eq key.answer?"checked":""}>B
                                <input type="radio" name="answer" value="C" ${"C" eq key.answer?"checked":""}>C
                                <input type="radio" name="answer" value="D" ${"D" eq key.answer?"checked":""}>D
                            </td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Update Question"></td>
                            <td><input type="reset" value="Reset"></td>
                        </tr>
                    </table>

                </form>
            </center>
    </body>
</html>