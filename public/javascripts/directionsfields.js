var count=4;
/*$("#stepNumber4").click(function(){

    var html="<div id='div"+count+"'><input type='textarea' cols="50" rows="4" id='add"+ count +"'></input></div>";
    $("#number").append(html);

    count++;
});*/

$("#addDirection").click(function(){
    //var html="<div id='div" + count + "'>";
    var html="<div id='div"+count+"'><input type='text' size='3' id='add" + count + "'></input></div>";
   /* for (var i = 4; i < types.length; i++)
    {
        html += "<option>";
        html += types[i];
        html +=" </option>";
    }*/
    html +="</select> ";
    html += "<div id='div"+count+"'><input type='textarea' cols='50' rows='4' id='add"+ count +"'></input></div>";
    //html += "<button type='button' onclick=remove('" + count + "')>Remove</button><br>";
    //html += </div>";
    $("#directions").append(html);

    count++;
});

/*function remove(which){
  $("#div"+which).remove();*/


