const express = require('express');
const app = express();
let mysql = require('mysql');

app.set("view engine", "ejs");
app.set("views", "views1")
app.use("/css", express.static(__dirname + "/css"));
app.use("/js", express.static(__dirname + "/js"));
app.use("/property", express.static(__dirname + "/property"));

app.use(express.urlencoded({ extended: true }));
app.use(express.json());

app.get("/", (req, res) => {
    res.render("property_view", { items: [] })
});

app.get("/search", (req, res) => {
    let con = mysql.createConnection({ host: "localhost", user: "root", password: "", database: "property" })
    let keyword = req.query.keyword || '';
    let sql = `SELECT * FROM w701_test_properties WHERE real_estate_name LIKE ? OR LOCATION LIKE ?`;
    con.connect((err) => {
        if (err) throw err;
        console.log("Connected!")
    })
    con.query(sql, ['%' + keyword + '%', '%' + keyword + '%'], (err, result, fields) => {
        if (err) throw err;
        res.render("property_view", { items: result })
    })
});

app.get("/property_detail/:id", (req, res) => {
    let con = mysql.createConnection({ host: "localhost", user: "root", password: "", database: "property" })
    let id = req.params.id || 0;
    let sql = `SELECT * FROM w701_test_properties WHERE id = ?`;
    con.connect((err) => {
        if (err) throw err;
        console.log("Connected!")
    })
    con.query(sql, [id], (err, result, fields) => {
        if (err) throw err;
        res.render("property_detail", { item: result[0] })
    })
});

app.listen(8080, () => {
    console.log("Start!!");
});