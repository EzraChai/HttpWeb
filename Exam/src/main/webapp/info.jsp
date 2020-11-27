<%@ page import="javax.servlet.http.HttpServletRequest" %>

<body>
    <center>
        <%
            String result = (String)request.getAttribute("info");
        %>
        <font style="color:red;font-size: 40px;">
            <%=result%>
        </font>
    </center>
</body>