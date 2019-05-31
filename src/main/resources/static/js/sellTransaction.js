function closeTransaction() {
    $(".transaction").empty().hide();
}
$(document).ready(closeTransaction);


$(document).ready(function() {
    $('.sellBtn').click(function(){
        let currency = this.dataset.currency;
        $(".transaction").empty().show().append("<span id=\"transaction\" data-currency=\"" + currency + "\"></span>");
        $("#transaction").html("How much " + currency + " units would you like to sell?");
        $(".transaction").show().append(transactionFirstWindow);
    });
});


const transactionFirstWindow = "<input type=\"number\" id=\"currencyAmount\" name=\"currencyAmount\" required\n" +
    "       minlength=\"4\" maxlength=\"6\" size=\"5\">" +
    "<input type=\"submit\" onclick=\"transactionConfirmation()\" value=\"Go to transaction\"> <br>" +
    "<input type=\"button\" onclick=\"closeTransaction()\" value=\"Cancel\">";


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
        $(".transaction").empty().show().append("<span id=\"transaction-accepted\"></span> <br>");
        $("#transaction-accepted").html("Are you sure, to exchange " + userInput + " " + passedCurrency +
        " for " + gainedPLN + " PLN?");
        $(".transaction").append("<input type=\"button\" id = \"accept-transaction-btn\" value=\"Accept\" " +
            "data-pln=\"" + gainedPLN + "\" " +
            "data-currency=\"" + passedCurrency + "\" " +
            "data-sold-amount=\"" + userInput + "\"" +
            " onclick=\"acceptTransaction()\"> <br>");
        $(".transaction").append("<input type=\"button\" onclick=\"closeTransaction()\" value=\"Cancel\">");
    }
}


function acceptTransaction() {

    let passedCurrency = $("#accept-transaction-btn").attr("data-currency");
    let passedGainingPLN = $("#accept-transaction-btn").attr("data-pln");
    let passedSoldUnits = $("#accept-transaction-btn").attr("data-sold-amount");
    let currentUSD = $("#USD-amount").text();
    let currentEUR = $("#EUR-amount").text();
    let currentCHF = $("#CHF-amount").text();
    let currentRUB = $("#RUB-amount").text();
    let currentCZK = $("#CZK-amount").text();
    let currentGBP = $("#CZK-amount").text();
    let currentPLN = $("#PLN-amount").text();

    let prepareNewAmounts = {
        usd : passedCurrency === "USD" ? currentUSD - passedSoldUnits : currentUSD,
        eur : passedCurrency === "EUR" ? currentEUR - passedSoldUnits : currentEUR,
        chf : passedCurrency === "CHF" ? currentCHF - passedSoldUnits : currentCHF,
        rub : passedCurrency === "RUB" ? currentRUB - passedSoldUnits : currentRUB,
        czk : passedCurrency === "CZK" ? currentCZK - passedSoldUnits : currentCZK,
        gbp : passedCurrency === "GBP" ? currentGBP - passedSoldUnits : currentGBP,
        pln : (currentPLN * 1) + (passedGainingPLN * 1)
    };

    $.ajax({
            url: 'saveUser',
            type: 'POST',
            data : JSON.stringify(prepareNewAmounts),
            dataType : 'json',
            contentType : "application/json"
    });
    location.reload(true);
    $(document).ready(cantorValues());
};
