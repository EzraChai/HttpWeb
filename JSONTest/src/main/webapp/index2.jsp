<%@ page isELIgnored="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
    <meta charset="UTF-8">
<head>
<title>Department Info</title>
<script>
    function init(){
        let deptObj = ${requestScope.key};
        for(var i = 0 ; i < deptObj.length; i ++){
            let jsonObj = deptObj[i];
            let trDom = document.createElement("tr");
            let tdDom_1 = document.createElement("td");
            let tdDom_2 = document.createElement("td");
            let tdDom_3 = document.createElement("td");

            tdDom_1.innerHTML = jsonObj.deptNo;
            tdDom_2.innerHTML = jsonObj.dname;//<td>Accounting</td>
            tdDom_3.innerHTML = jsonObj.location;
            trDom.appendChild(tdDom_1);
            trDom.appendChild(tdDom_2);
            trDom.appendChild(tdDom_3);

            document.getElementById("one").appendChild(trDom);

        }
    }
</script>
</head>
<body onload="init()">
<center>
    <table border ="2" align="center" id="one">
        <tr>
            <td>部门编号</td>
            <td>部门名称</td>
            <td>部门位置</td>
        </tr>
    </table>
</center>
</body>
</html>
