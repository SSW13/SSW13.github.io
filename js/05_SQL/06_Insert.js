var mysql = require('mysql');
var con = mysql.createConnection({
    host: "localhost",
    user: "root",
    password: "",
    database: "shopjs"
});
con.connect(function(err) {
    if (err) throw err;
    console.log("Connected!");
    var sql = `INSERT INTO produxt (id, name, price, stock) VALUES 
    ('0', 'aaaa', 500, 10)`;
    con.query(sql, function(err, result) {
        if (err) throw err;
        console.log("1 record inserted");
    });
    con.end();
});