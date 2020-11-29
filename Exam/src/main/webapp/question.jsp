<%@ page import="javax.servlet.http.HttpServletRequest,java.util.List,com.Entity.Question" %>


<table border="2" align="center">
                <tr>
                    <td>Title</td>
                    <td>A</td>
                    <td>B</td>
                    <td>C</td>
                    <td>D</td>
                    <td>Answer</td>
                    <td colspan="2" align="center">Control</td>

                </tr>
                <%
                    List list = (List)request.getAttribute("key");
                    for(int i = 0;i < list.size(); i++){
                        Question question = (Question) list.get(i);

                        if(i % 2 == 0){
                        %>
                        <tr style="background-color: lightgray;">
                        <%
                        }
                        else{
                        %>
                        <tr>
                        <%
                        }
                        %>
                            <td><%=question.getTitle()%></td>
                            <td><%=question.getOptionA()%></td>
                            <td><%=question.getOptionB()%></td>
                            <td><%=question.getOptionC()%></td>
                            <td><%=question.getOptionD()%></td>
                            <td><%=question.getAnswer()%></td>
                            <td> <a href="/Exam/question/delete?questionId=<%=question.getQuestionId()%>">Delete</a></td>
                            <td> <a href="/Exam/question/findById?questionId=<%=question.getQuestionId()%>">Info</a></td>
                        </tr>

                <%
                    }
                %>
            </table>