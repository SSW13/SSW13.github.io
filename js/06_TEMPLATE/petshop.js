const express = require('express');
const app = express();
app.set('view engine', 'ejs');
app.set('views', 'views')

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
            res.render("shop_template", { products: result });
            con.end();
        });
    });
});

app.get('/insert', (req, res) => {
    var mysql = require('mysql');

    var con = mysql.createConnection({
        host: "localhost",
        user: "root",
        password: "",
        database: "shopjs"
    });

    let name = req.query.name || "no_name";
    let price = req.query.price || 0;
    let stock = req.query.stock || 0;

    con.connect(function(err) {

        if (err) throw err;
        let sql = `INSERT INTO produxt (name, price, stock) VALUE (?,?,?)`;
        con.query(sql, [name, price, stock], function(err, result) {
            if (err) throw err;
            let sql = `SELECT * FROM produxt ORDER BY id`;
            con.query(sql, function(err, result, fields) {
                if (err) throw err;
                console.log(result);

                res.status = 200;
                res.render("shop_template", { products: result });
                con.end();
            });
        });
    });
});



app.get('/updatestock/:id/:add', (req, res) => {
    var mysql = require('mysql');

    var con = mysql.createConnection({
        host: "localhost",
        user: "root",
        password: "",
        database: "shopjs"
    });

    let id = req.params.id || 0;
    let addstock = req.params.add || 0;

    con.connect(function(err) {

        if (err) throw err;
        let sql = "";
        if (addstock == 1) {
            sql = `UPDATE produxt SET stock = stock + 1 WHERE id = ?`;
        } else if (addstock == -1) {
            sql = `UPDATE produxt SET stock = stock - 1 WHERE id = ?`;
        }
        con.query(sql, [id], function(err, result) {
            if (err) throw err;
            let sql = `SELECT * FROM produxt ORDER BY id`;
            con.query(sql, function(err, result, fields) {
                if (err) throw err;
                console.log(result);

                res.status = 200;
                res.render("shop_template", { products: result });
                con.end();
            });
        });
    });
});

app.get('/deletestock/:id/', (req, res) => {
    var mysql = require('mysql');

    var con = mysql.createConnection({
        host: "localhost",
        user: "root",
        password: "",
        database: "shopjs"
    });

    let id = req.params.id || 0;

    con.connect(function(err) {

        if (err) throw err;
        let sql = `DELETE FROM produxt WHERE id = ?`;
        con.query(sql, [id], function(err, result) {
            if (err) throw err;
            let sql = `SELECT * FROM produxt ORDER BY id`;
            con.query(sql, function(err, result, fields) {
                if (err) throw err;
                console.log(result);

                res.status = 200;
                res.render("shop_template", { products: result });
                con.end();
            });
        });
    });
});






app.listen(8080, () => {
    console.log("Start !!")
});