function cantorValues() {
    console.log('cantorValues updated')
    $.ajax({
        url: "http://webtask.future-processing.com:8068/currencies",
        type: 'GET',
        success: function (result) {
            for (let i = 0; i < result.items.length; i++) {
                $("#" + result.items[i].code + "-buy-value").html("" + result.items[i].sellPrice)
                $("#" + result.items[i].code + "-sell-value").html("" + result.items[i].purchasePrice)
            }
        },
        error: function () {
            alert('error');
        }
    });
}
$(document).ready(cantorValues());

setInterval(cantorValues, 20000);