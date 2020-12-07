<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>State Ajax</title>
    <script>
        function search(){
            let xmlHttp = new XMLHttpRequest();
            xmlHttp.onreadystatechange =  function(){
                if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
                    let data = xmlHttp.responseText;
                    let jsonObj = eval("("+data+")");
                    callback(jsonObj);
                }
            }
            id = document.getElementById("stateId").value;
            xmlHttp.open("get","queryjson?id="+id ,true);
            xmlHttp.send();
        }

        function callback(json){
            document.getElementById("stateName").value = json.name;
            document.getElementById("stateAbbreviation").value = json.abbreviation;
            document.getElementById("stateCapital").value = json.capital;
        }
    </script>
</head>
<body>
    <table border="2">
        <tr>
            <td>State's ID</td>
            <td><input type="text" id="stateId"><input type="button" value="Search" onclick="search()"></td>
        </tr>
        <tr>
            <td>State's Name</td>
            <td><input type="text" id="stateName"></td>
        </tr>
        <tr>
             <td>State's Abbreviation</td>
             <td><input type="text" id="stateAbbreviation"></td>
        </tr>
        <tr>
            <td>State's Capital</td>
            <td><input type="text" id="stateCapital"></td>
        </tr>
    </table>
</body>
</html>