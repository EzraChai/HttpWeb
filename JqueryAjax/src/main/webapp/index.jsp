<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>City</title>
    <script  src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        $(function(){
        $("#city").hide()
        $("#word").hide()
        $(":button").hide()
        $(":button").on("click",function(){
            let place = $("#option option:selected").text()
            alert(place)
        })
            $("#state").on('change',function(){
                if($("#state option:selected").val() == 0){
                    $("option[class='city']").remove()
                    $("#city").hide()
                    $("#word").hide()
                }else{
                $.post({
                    url:"queryCity",
                    data:{
                        "id": this.value,
                    },
                    dataType: "json",
                    success: function(resp){
                        $("option[class='city']").remove()
                        let num = 0;
                        let $option = $("#option")
                        $("#word").show()
                        $("#city").show()
                        $(":button").show()

                        $(resp.name).each(function(i,n){
                        num +=1;
                            $("#city").append($("<option>",{value:num,class:"city",text:n}))
                        })
                    }
                })
            }})
        })
    </script>
</head>
<body>
    <center>
    <table>
        <tr>
            <td>Malaysia's State</td>
        </tr>
        <tr>
            <td>
                <select name="State" id="state">
                    <option value="0">--Please choose your state--</option>
                    <option value="1">Johor</option>
                    <option value="2">Kedah</option>
                    <option value="3">Kelantan</option>
                    <option value="4">Malacca</option>
                    <option value="5">Negeri Sembilan</option>
                    <option value="6">Pahang</option>
                    <option value="7">Perlis</option>
                    <option value="8">Penang</option>
                    <option value="9">Perak</option>
                    <option value="10">Sabah</option>
                    <option value="11">Selangor</option>
                    <option value="12">Sarawak</option>
                    <option value="13">Terengganu</option>
                </select>
            </td>
        </tr>
        <tr>
                    <td>
                        <div id="word">
                        Malaysia City
                         </div>
                    </td>
                </tr>
        <tr>
            <td>
                <div id="option">
                <select name='City' id='city'>
                 </div>
            </td>
        </tr>
        <tr>
                    <td><br>
                        <div id="Submit">
                        <input type="button" value="Submit">
                         </div>
                    </td>
                </tr>

    </table>
    </center>
</body>
</html>