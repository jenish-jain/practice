var searchBtn = document.getElementById("search");
var count = 0;

searchBtn.addEventListener("click", searchLocation);
function searchLocation() {
    var city = document.getElementById("search-bar").value;
    console.log("searching for : " + city);
    var xhr = new XMLHttpRequest();
    xhr.addEventListener("readystatechange", function () {
        if (this.readyState === 4) {
            console.log(this.responseText);
            var data = JSON.parse(this.responseText); // parsed json object
            console.log(data);
            var cities = data.location_suggestions;
            cities.forEach(createCityCard);
        }
    });
    var url = "https://developers.zomato.com/api/v2.1/locations?count=10&query=";
    xhr.open("GET", url + city);
    xhr.setRequestHeader("user-key", "c2d571ebc11180f588de56ea23d10096");
    xhr.send(null);
}

function createCityCard(city) {
    count = count + 1;
    console.log(count);
    document.getElementById("result-count").innerHTML = "total searches made are " + count;

    console.log(city.city_name);
    console.log(city.city_id);
    console.log(city.country_id);
    console.log(city.country_name);
    console.log(city.entity_type);

    var card = document.createElement("div");
    card.className = "card " + city.entity_type;
    var cardHeader = document.createElement("div");
    cardHeader.className = "card-header";
    cardHeader.innerText = city.city_name;
    var cardBody = document.createElement("div");
    cardBody.className = "card-body";
    var cardTitle = document.createElement("div");
    cardTitle.innerHTML = 
    "<p> City Title : " + city.title +"</p>"
    +"<p> Country name : " + city.country_name +"</p>"
    +"<p> Country id : " + city.country_id +"</p>"
    +"<p> City id : " + city.city_id +"</p>" 
    +"<p> City type : " + city.entity_type +"</p>"
    +"<p> Location => Latitute: " + city.latitude + " Longitude : "+ city.longitude +"</p>"
    ;
    // card.className = city.entity_type;
    card.appendChild(cardHeader);
    card.appendChild(cardBody);
    cardBody.appendChild(cardTitle);
    document.body.appendChild(card);
}