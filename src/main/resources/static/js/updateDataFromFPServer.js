function cantorValues() {
    console.log('cantorValues updated')
    $.ajax({
        url: "http://webtask.future-processing.com:8068/currencies",
        type: 'GET',
        success: function (result) {
            for (let i = 0; i < result.items.length; i++) {
                let sellPrice = result.items[i].sellPrice;
                let purchasePrice = result.items[i].purchasePrice;
                let unit = result.items[i].unit;
                $("#" + result.items[i].code + "-buy-value").html("" + sellPrice);
                $("#" + result.items[i].code + "-sell-value").html("" + purchasePrice);
                let currencyValue = ($("#" + result.items[i].code + "-amount").text() * purchasePrice) / unit;
                currencyValue= currencyValue.toFixed(2);
                $("#" + result.items[i].code + "-value").html("" + currencyValue)
            }
        },
        error: function () {
            alert('something went wrong, we could not update currencies');
        },
    });
}
$(document).ready(cantorValues());

setInterval(cantorValues, 20000);