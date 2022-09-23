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
    var sql = ` SHOW TABLES`;
    con.query(sql, function(err, result) {
        if (err) throw err;
        console.log("Table created");
        console.log(result);
    });
});