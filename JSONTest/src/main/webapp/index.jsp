<%@ page isELIgnored="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
    <meta charset="UTF-8">
<head>
<title>Department Info</title>
<script>
    function init(){
        let deptObj = ${requestScope.key};
        document.getElementById("deptNo").value = deptObj.deptNo;
        document.getElementById("dname").value = deptObj.dname;
        document.getElementById("location").value = deptObj.location;
    }
</script>
</head>
<body onload="init()">
<center>
    <table border ="2">
        <tr>
            <td>部门编号</td>
            <td><input type="text" id="deptNo"></td>
        </tr>
        <tr>
            <td>部门名称</td>
            <td><input type="text" id="dname"></td>
        </tr>
        <tr>
            <td>部门位置</td>
            <td><input type="text" id="location"></td>
        </tr>
    </table>
</center>
</body>
</html>
