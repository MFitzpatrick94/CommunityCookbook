var types= document.getElementById("amount").getAttribute("amountsId").split(",");
var types2= document.getElementById("amount").getAttribute("quantity").split(",");
var count=4;

$("#addIngredient").click(function(){

   var html = "<select name='amount"+ count +"' id = 'amountId" +count +"'>";
      for(var i = 0; i<types.length; i++)
        {
        html+= "<option>";
        html += types[i];
        html += "</option>";
        }
    html += "</select>";
    html+= "<select name='measurement"+count+"' id='measurementId"+count+"'>";
        for(var j = 0; j<types2.length; j++)
                {
                html+= "<option>";
                html += types2[j];
                html += "</option>";
                }
    html+="</select>"
    html+= "<input type='text' name='ingredient"+count+"' id='ingredientName"+ count+"' maxlength='100'>"
   html+= "<br>";

   $("#ingredients").append(html);

       count++;
   });