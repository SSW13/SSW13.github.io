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
    var sql = `CREATE TABLE produxt (id INT AUTO_INCREMENT PRIMARY KEY, 
        name VARCHAR(255), price FLOAT(7,2)
        )`;
    con.query(sql, function(err, result) {
        if (err) throw err;
        console.log("Table created");
    });
});