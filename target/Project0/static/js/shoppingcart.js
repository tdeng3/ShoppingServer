const placeProduct = function (id,name,orderDate,price,statusId,status) {
    const tableBody = document.getElementById('cart-table-data');
    const entry = document.createElement('tr');
    entry.innerHTML=
    `<td>${id}</td>
    <td>${name}</td>
    <td>${orderDate}</td>
    <td>${price}</td>
    <td>${statusId}</td>
    <td>${status}</td>`;
    tableBody.appendChild(entry);
}
const getProduct = function () {
    const xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        console.log("readyState: " + this.readyState + " status: " + this.status);
        if (this.readyState == 4 && this.status == 200) {
            const data = JSON.parse(xhr.responseText);

            for(let i = 0; i < data.length; i++) {
                placeProduct(data[i].id, data[i].name, data[i].orderDate, data[i].price, data[i].status.id,data[i].status.status);
            }

            console.log("Data received" + data);
        }
    }
    xhr.open('GET', 'http://3.135.225.25:8080/Project0/ProductWithStatus');
    xhr.send();
}

getProduct();
console.log("done");