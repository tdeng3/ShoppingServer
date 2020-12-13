const placeProduct = function(id, name, description, price) {

}
const getProduct = function () {
    const xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function (){
        
        if (this.readyState == 4 && this.status == 200) {
            const data = JSON.parse(xhr.responseText);
            for (let i = 0; i<data.length; i++) {
                placeProduct(data[i].id,data[i].name,data[i].orderDate,data[i].price,data[i].status.id,data[i].status.status);
            }
            console.log("Product data received");
        }
    }
    xhr.open('GET','http://3.135.225.25:8080/Project0/ProductWithStatus');
    xhr.send();
}

getProduct();
console.log("Hi");