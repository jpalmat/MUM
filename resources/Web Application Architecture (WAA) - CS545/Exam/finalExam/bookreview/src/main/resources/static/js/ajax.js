function addCategory() {
    var dataToSend = JSON.stringify(serializeObject($("#categoryForm")))

    $.ajax({
        type: "POST",
        url: "http://localhost:9090/categoryrest/add",
        data: dataToSend,
        dataType: "json",
        contentType: "application/json",

        success: function (categories) {
            console.log("Categories", categories)
            $("#categoryData").html("")

            var message;
            $.each(categories, function (index, category) {
                message +=
                    "<tr>" +
                    "<td>" + category.id + "</td>" +
                    "<td>" + category.name + "</td>" +
                    "</tr>";
            });

            $("#categoryData").append(message);
        },
        error: function (errors) {
            console.log("Errors", errors)
            if(errors.responseJSON.errorType==="ValidationError"){
                var errorList = errors.responseJSON.fieldErrors;
                var message = "<ul>"
                $("#errors").html("")

                $.each(errorList, function (index, error) {
                    message+="<li>" + error.field + ": " + error.message +"</li>"
                })
                message+="</ul>";
                $("#errors").append(message);
            }else
            {
                alert("Error type not found")
            }
        }
    })
}

// Translate form to array

// Then put in JSON format
function serializeObject(form) {
    var jsonObject = {};
    var array = form.serializeArray();
    $.each(array, function () {
        jsonObject[this.name] = this.value;
    });
    return jsonObject;

};