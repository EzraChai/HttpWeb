<%@ page import="java.util.List,com.dao.userDao,com.Entity.User" %>

<%
userDao dao = new userDao();
List<User> userlist = dao.findAll();
%>
<body>

    <table border = '2' align='center'>
    <tr>
    <td>User ID</td>
    <td>Username</td>
    <td>Password</td>
    <td>Gender</td>
    <td>Email</td>
    <td>Control</td>
    </tr>
    <%for (User users : userlist) {%>
    <tr>
    <td> ${users.getUserId()} </td>
    <td> ${users.getName()} </td>
    <td> *********** </td>
    <td> ${users.getGender()} </td>
    <td> ${users.getEmail()}  </td>
    <td><a href='/Exam/delete?userId=
    <%=users.getUserId()%>
    '>Delete</a></td>
    </tr>
    <%}%>
</body>