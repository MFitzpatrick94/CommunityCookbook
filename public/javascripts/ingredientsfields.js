var types= document.getElementById("amount").getAttribute("amountsId").split(",");
var types2= document.getElementById("amount").getAttribute("quantity").split(",");
var types3 = document.getElementById("amount").getAttribute("quantityIds").split(",");
var types4 = document.getElementById("amount").getAttribute("amounts").split(",");
var count=4;

$("#addIngredient").click(function(){

   var html = "<select name='amountId"+ count +"' id = 'amountId" +count +"'>";
      for(var i = 0; i<types.length; i++)
        {
        html+= "<option value = '" + types4[i] + "'>";
        html += types[i];
        html += "</option>";
        }

    html += "</select>";
    html+= "<select name='measurementId"+count+"' id='measurementId"+count+"'>";
        for(var j = 0; j<types2.length; j++)
                {
                html+= "<option value = '" + types3[j] + "'>";
                html += types2[j];
                html += "</option>";
                }

    html+="</select>"
    html+= "<input type='text' name='ingredientName"+count+"' id='ingredientName"+ count+"' maxlength='100'>"
   html+= "<br>";

   $("#ingredients").append(html);

       count++;
   });