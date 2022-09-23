var mysql = require('mysql');
class MySQLDB {
    getConfig() {
        return {
            host: "localhost",
            user: "root",
            password: "",
            database: "shopjs"
        };
    }


    openDatabaseConnection(config, callback) {
        let con = mysql.createConnection(config);

        con.connect((err) => {
            if (err) throw err;
            callback(null, con);
        });
    }

    getAllData(callback) {

    }
}

exports.MySQLDB = MySQLDB;