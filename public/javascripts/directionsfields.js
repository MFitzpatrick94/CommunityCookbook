var count2=4;

$("#addDirection").click(function(){

    var html="<input type='text' name='stepNumber" + count2+ "' value='"+ count2 +"' size='3' maxlength='3' id='add" + count2 + "'></input>";
       html += "<textarea name='step" + count2 + "' cols='50' rows='4' id='add"+ count2 +"'></textarea>";
       html += "<p></p>";
    $("#directions").append(html);

    count2++;
});



