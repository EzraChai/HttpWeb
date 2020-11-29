<%@ page import="javax.servlet.http.HttpServletRequest,javax.el.*,java.io.*" %>
<%@ page isELIgnored="false" %>

<body>
    <center>
        <font style="color:red;font-size: 40px;">
            ${questionUpdate != null?"Question Update Completely.":""}
            ${questionDelete != null?"Question Deleted.":""}
            ${questionAdd != null?"Question Added Completely.":""}
            ${score != null? score:""}
        </font>
    </center>
</body>