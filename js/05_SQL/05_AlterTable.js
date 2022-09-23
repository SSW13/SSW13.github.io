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
    var sql = `ALTER TABLE produxt ADD COLUMN stock INT(10);`;
    con.query(sql, function(err, result) {
        if (err) throw err;
        console.log("Table created");
    });
});