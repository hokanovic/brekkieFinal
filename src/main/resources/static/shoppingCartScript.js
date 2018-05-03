function addToCart() {
    var x = document.getElementsByClassName("productQty")
    var i;
    for (i = 0; i < x.length; i++) {
        var qty = x[i].value
        if (qty.length > 0) {
            var xx = document.getElementsByClassName("product")
            var productName = xx[i].innerHTML
            var xxx = document.getElementsByClassName("productId")
            var productId = xxx[i].innerHTML
            var xxxx = document.getElementsByClassName("bagId")
            var bagId = xxxx[i].innerHTML
            var newRow = document.getElementById('cart').insertRow();
            newRow.innerHTML =
                "<td>productName\":\"" + productName + "</td>" +
                "<td hidden>bagId\":\"" + bagId + "</td>" +
                "<td hidden>productId\":\"" + productId + "</td>" +
                "<td>productQty\":\"" + qty + "</td>";
        }
    }
    var x = document.getElementsByClassName("productQty")
    var i;
    for (i = 0; i < x.length; i++) {
        x[i].value = "";
    }
}
function html2json() {
    var json = '[';
    var otArr = [];
    // var i = 1;
    var tbl2 = $('table tbody tr').each(function (e) {
        x = $(this).children();
        var itArr = [];
        x.each(function () {
            itArr.push('"' + $(this).text() + '"');
        });
        otArr.push('{' + itArr.join(',') + '}');
    })
    json += otArr.join(",") + ']'

    return json;
}
function sendJson() {
    var jsonOrders = html2json();
    console.log(jsonOrders)
    $.ajax({
        type: "POST",
        error: function () {
            $(document.body).css({'cursor': 'default'});
            console.log("error sending the data");
            window.location="/error";
        },
        contentType: "application/json; charset=utf-8",
        data: jsonOrders,
        url: "/frukost", //which is mapped to its partner function on our controller class
        success: function (result) {
            console.log("successfully inserted ", result);
            window.location="/frukost";
        }
    });
}