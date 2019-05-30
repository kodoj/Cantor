function closeTransaction() {
    $(".transaction").empty().hide();
}
$(document).ready(closeTransaction);

function transactionConfirmation() {
    let passedCurrency = $("#transaction").attr("data-currency");
    let userInput = $('#currencyAmount').val();
    let amount = $("#" + passedCurrency + "-amount").text();
    let unit = $("#" + passedCurrency + "-unit").text();
    if (userInput * unit > amount) {
        $(".transaction").empty().append("<span id=\"transaction-declined\"></span> <br>");
        $("#transaction-declined").html("Sorry, you don't have this much!");
        $(".transaction").append("<input type=\"button\" onclick=\"closeTransaction()\" value=\"Cancel\">");
    } else {
        let unitPrice = $("#" + passedCurrency + "-sell-value").text();
        let gainedPLN = userInput * unitPrice;
        gainedPLN = gainedPLN.toFixed(2);
            $(".transaction").empty().show().append();
    }

}

const transactionFirstWindow = "<input type=\"number\" id=\"currencyAmount\" name=\"currencyAmount\" required\n" +
    "       minlength=\"4\" maxlength=\"6\" size=\"5\">" +
    "<input type=\"submit\" onclick=\"transactionConfirmation()\" value=\"Go to transaction\"> <br>" +
    "<input type=\"button\" onclick=\"closeTransaction()\" value=\"Cancel\">";


$(document).ready(function() {
    $('.sellBtn').click(function(){
        let currency = this.dataset.currency;
        $(".transaction").empty().show().append("<span id=\"transaction\" data-currency=\"" + currency + "\"></span>");
        $("#transaction").html("How much " + currency + " units would you like to sell?");
        $(".transaction").show().append(transactionFirstWindow);
    });
});

//
// $.ajax({
//     type: "POST",
//     url: "/saveUser",
//     data: {
//         id: $("#button_1").val(),
//         access_token: $("#access_token").val()
//     },
//     success: function(result) {
//         alert('ok');
//     },
//     error: function(result) {
//         alert('error');
//     }
// });
