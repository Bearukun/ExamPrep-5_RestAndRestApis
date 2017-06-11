var btn = document.getElementById("btn");
var tbody = document.getElementById("bodyT");

var people;
var fetchedPerson;

//Function to fetch people from the database through the REST Api.
function fetchCountries() {

    var url = "http://localhost:8084/ExamPrep-5_RestAndRestApis/api/world";
    var conf = {method: 'get'};
    var promise = fetch(url, conf);

    promise.then(function (response) {

        return response.text();

    }).then(function (text) {


        document.getElementById("bodyT").innerHTML = listMaker(text);

    });


}

//Function to generate a formated list to pupulate the table on the website
function listMaker(arr) {

    var parsed = JSON.parse(arr);
    var lis = parsed.map(function (countries) {

        return  "<tr>" +
                "<td>" + countries.name + "</td>" +
                "<td>" + countries.population + "</td>" +
                "</tr>";

    });
    return lis.join("");
}
;

fetchCountries();




