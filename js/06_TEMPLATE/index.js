const express = require('express');
const fs = require('fs');
const app = express();

function showAllProduct(database_result) {
    let output = [];
    output.push(`<table style="border: 1px solid black; border-collapse: collapse;background-color: #96D4D4;">`);
    output.push("<tr>");
    output.push("<th>" + "id" + "</th>");
    output.push("<th>" + "name" + "</th>");
    output.push("<th>" + "stock" + "</th>");
    output.push("<th>" + "price" + "</th>");
    output.push("</tr>");
    for (let i = 0; i < database_result.length; i++) {
        output.push("<tr>");
        output.push("<td>" + database_result[i].id + "</td>");
        output.push("<td>" + database_result[i].name + "</td>");
        output.push("<td>" + database_result[i].stock + "</td>");
        output.push("<td>" + database_result[i].price + "</td>");
        output.push("</tr>");
    }
    output.push("</table>");
    console.log(output.toString());
    return output.join("\n");

}


app.get('/', (req, res) => {
    var mysql = require('mysql');

    var con = mysql.createConnection({
        host: "localhost",
        user: "root",
        password: "",
        database: "shopjs"
    });

    con.connect(function(err) {
        if (err) throw err;
        let sql = `SELECT * FROM produxt ORDER BY id`;
        con.query(sql, function(err, result, fields) {
            if (err) throw err;
            console.log(result);

            res.status = 200;
            fs.readFile("./index.html", (err, data) => {
                let front_end = data.toString();
                let table = showAllProduct(result);
                front_end = front_end.replace(/\{\{products\}\}/g, table);
                res.write(front_end);
                res.end();
            })





            con.end();
        });
    });
});





app.listen(8080, () => {
    console.log("Start !!")
});