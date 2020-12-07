<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BMI</title>
    <script>

        function doAjax(){
            let xmlHttp = new XMLHttpRequest();

            xmlHttp.onreadystatechange = function(){
                //alert("readyState ready " + xmlHttp.readyState+"| status: " + xmlHttp.status)
                if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
                    let text = document.getElementById("span");
                    text.innerText = (xmlHttp.responseText);
                }
            }
            let name = document.getElementById("name").value;
            let weight = document.getElementById("weight").value;
            let height = document.getElementById("height").value;

            let param = "Name="+name+"&Weight="+weight+"&Height="+height;

            xmlHttp.open("get","bmiAjax?"+param,true);

            xmlHttp.send();
        }

    </script>
</head>
<body>
    <p>Calculate BMI</p>
    <div>
        Name : <input type="text" name="Name" id="name"><br>
        Weight(kg) : <input type="text" name="Weight" id="weight"><br>
        Height(cm) : <input type="text" name="Height" id="height"><br>
        <input type="button" value="Submit" onclick="doAjax()" >
    </div>
    <br>
    <div>
    <span id="span"><span>
    </div>
</body>
</html>