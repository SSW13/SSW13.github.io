const express = require('express');
const app = express();
const crypto = require('crypto');
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

app.get("/login", (req, res) => {
    let pass_wrong = req.query.password || "";
    if (pass_wrong == "wrong") {
        pass_wrong = true;
    } else {
        pass_wrong = false;
    }
    res.render("login", { pass: pass_wrong })
});


app.post("/login", (req, res) => {
    let user = req.body.name || "";
    let pass = req.body.password || "";
    const hash = crypto.createHash('sha256').update(pass).digest('base64');
    let con = mysql.createConnection({ host: "localhost", user: "root", password: "", database: "property" })
    console.log(hash);
    let sqlCheck = `SELECT count(*) AS count FROM users WHERE email = ? AND password = ?`;
    con.query(sqlCheck, [user, hash], (err, result, fields) => {
        if (err) throw err;
        if (result[0].count > 0) {
            res.redirect("/");
        } else {
            res.redirect("/login?password=wrong");
        }

    });
});


app.get("/register", (req, res) => {
    res.render("register")
});

app.post('/register', (req, res) => {
    let con = mysql.createConnection({ host: "localhost", user: "root", password: "", database: "property" })
    let email = req.body.email || "";
    let password = req.body.password || "";
    let name = req.body.name || "";
    let phone = req.body.phone || "";

    let sqlCheck = `SELECT count(*) AS count FROM users WHERE email = ?`;
    con.connect((err) => {
        if (err) throw err;
        console.log("Connected!")
    })

    con.query(sqlCheck, [email], (err, result, fields) => {
        if (err) throw err;

        if (result[0].count > 0) {
            res.render("register_fail")
        } else {
            let sql = `INSERT INTO users (id, email, password, name, phone) VALUES (0, ?, ?, ?, ?)`;
            const hash = crypto.createHash('sha256').update(password).digest('base64');
            con.query(sql, [email, hash, name, phone], (err, result, fields) => {
                if (err) throw err;
                res.render("register_success")

            })
        }
    })
})

app.listen(8080, () => {
    console.log("Start!!");
});