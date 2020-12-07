<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script>
        function search(){
            let xmlHttp = new XMLHttpRequest();
            let stateId = document.getElementById("stateId").value
            xmlHttp.onreadystatechange = function(){
               if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
                    let value = xmlHttp.responseText;
                    document.getElementById("stateName").value = value
               }
            }

            let param = "stateId="+stateId
            xmlHttp.open("get","queryState?"+param,true);
            xmlHttp.send();
        }
    </script>
    <title>State</title>
</head>
<body>
    <table>
        <tr>
            <td>State's ID</td>
            <td><input type="text" id="stateId"><input type="button" value="Search" onclick="search()"></td>
        </tr>
        <tr>
            <td>State's Name</td>
            <td><input type="text" id="stateName"></td>
        </tr>
    </table>
</body>
</html>