const placeUser = function (id,email,password,role) {
    const tableBody = document.getElementById('user-table-data');
    const entry = document.createElement('tr');
    entry.innerHTML = 
    `<td>${id}</td>
    <td>${email}</td>
    <td>${password}</td>
    <td>${role}</td>`;
    tableBody.appendChild(entry);

}

const getUser = function () {
    const xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function (){
        console.log("readyState: "+this.readyState +" status: "+ this.status );
        if(this.readyState == 4 && this.status == 200) {
            const data = JSON.parse(xhr.responseText);
            console.log("data: " + data);
            for(let i = 0; i < data.length; i++ ){
                placeUser(data[i].id, data[i].email,data[i].password, data[i].role);
            }
            console.log("Data received" + data);
        }
        
    }
    xhr.open('GET', 'http://3.135.225.25:8080/Project0/ShowAllUsers');
    xhr.send();
}

getUser();
console.log("Hi");