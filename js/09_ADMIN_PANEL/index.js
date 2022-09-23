const express = require('express');
const app = express();
const crypto = require('crypto');
let mysql = require('mysql');
const cookiesSession = require('cookie-session');
const multer = require('multer');
const path = require('path');
const upload = multer({ dest: 'temp/' });
const fs = require('fs');


app.set("view engine", "ejs");
app.set("views", "views1")
app.use("/css", express.static(__dirname + "/css"));
app.use("/js", express.static(__dirname + "/js"));
app.use("/property", express.static(__dirname + "/property"));

app.use(express.urlencoded({ extended: true }));
app.use(express.json());

app.use(cookiesSession({
    name: 'session',
    keys: ['key1', 'key2'],
    maxAge: 24 * 60 * 60 * 100
}));

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
    let sqlCheck = `SELECT * FROM users WHERE email = ? AND password = ?`;
    con.query(sqlCheck, [user, hash], (err, result, fields) => {
        if (err) throw err;
        if (result.length > 0) {
            req.session.username = result[0].name;
            req.session.userrole = result[0].role;
            req.session.useremail = result[0].email;
            res.redirect("/dashboard");
        } else {
            res.redirect("/login?password=wrong");
        }

    });
});

app.get("/logout", (req, res) => {
    req.session = null;
    res.redirect('/');

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
    })

    con.query(sqlCheck, [email], (err, result, fields) => {
        if (err) throw err;

        if (result[0].count > 0) {
            res.render("register_fail")
        } else {
            let sql = `INSERT INTO users (id, email, password, name, phone, role) VALUES (0, ?, ?, ?, ?, 'user')`;
            const hash = crypto.createHash('sha256').update(password).digest('base64');
            con.query(sql, [email, hash, name, phone], (err, result, fields) => {
                if (err) throw err;
                res.render("register_success")

            })
        }
    })
})


app.get("/dashboard", (req, res) => {
    if (req.session.username != undefined) {
        res.render('dashboard/index', {
            name: req.session.username,
            role: req.session.userrole
        });
    } else {
        res.redirect('/login');
    }
});

app.get("/dashboard/user", (req, res) => {
    if (req.session.username != undefined) {
        let con = mysql.createConnection({ host: "localhost", user: "root", password: "", database: "property" })
        let email = req.session.useremail || "";
        let sqlCheck = ``;
        if (req.session.userrole == 'admin') {
            sqlCheck = `SELECT * FROM users ORDER BY id`;
        } else {
            sqlCheck = `SELECT * FROM users WHERE email = ?`;
        }

        con.query(sqlCheck, [email], (err, results, fields) => {
            if (err) throw err;
            res.render('dashboard/user_manage', { users: results });
        });
    } else {
        res.redirect('/login');
    }
});

app.post("/dashboard/user/edit", (req, res) => {
    if (req.session.username != undefined) {
        let con = mysql.createConnection({ host: "localhost", user: "root", password: "", database: "property" })
        let newrole = req.body.newrole || "";
        let id = req.body.id || "";


        let sqlCheck = ``;
        sqlCheck = `UPDATE users SET role = ? WHERE id = ?`;


        con.query(sqlCheck, [newrole, id], (err, results, fields) => {
            if (err) throw err;
            res.redirect('/dashboard');
        });
    } else {
        res.redirect('/login');
    }
});


app.get("/dashboard/property", (req, res) => {
    if (req.session.username != undefined) {
        let con = mysql.createConnection({ host: "localhost", user: "root", password: "", database: "property" })

        let sqlCheck = `SELECT * FROM w701_test_properties ORDER BY id`;

        con.query(sqlCheck, [], (err, results, fields) => {
            if (err) throw err;
            res.render('dashboard/property_manage', {
                properties: results
            })
        });
    } else {
        res.redirect('/login');
    }
});


app.get("/dashboard/property/edit", (req, res) => {
    if (req.session.username != undefined) {
        let con = mysql.createConnection({ host: "localhost", user: "root", password: "", database: "property" })
        let id = req.query.id || "";


        let sqlCheck = ``;
        sqlCheck = `SELECT * FROM w701_test_properties WHERE  id = ?`;


        con.query(sqlCheck, [id], (err, results, fields) => {
            if (err) throw err;
            res.render('dashboard/property_manage_edit', {
                item: results[0]
            });
        });
    } else {
        res.redirect('/login');
    }
});

let fileNameToUpload = [
    { name: 'image', maxcount: 5 }
];

app.post("/dashboard/property/edit", upload.fields(fileNameToUpload), (req, res) => {
    if (req.session.username != undefined) {
        let con = mysql.createConnection({ host: "localhost", user: "root", password: "", database: "property" })

        console.log(req.files.image[0].originalname);
        console.log("aaa");


        let canUseFile = [true, true, true, true, true];

        for (let i = 0; i < req.files.image.length; i++) {
            const targetPath = path.join(__dirname, "./property/" + req.files.image[i].originalname);
            if (path.extname(req.files.image[i].originalname).toLowerCase() === ".png" ||
                path.extname(req.files.image[i].originalname).toLowerCase() === ".jpg" ||
                path.extname(req.files.image[i].originalname).toLowerCase() === ".jpeg") {
                fs.rename(req.files.image[i].path, targetPath, err => {
                    if (err) return handleError(err, res);
                });
            } else {
                fs.unlink(tempPath, err => {
                    if (err) return handleError(err, res);
                    canUseFile[i] = false;
                });
            }
        };


        let id = req.body.id || "";

        let real_estate_name = req.body.real_estate_name || "";
        let lat = req.body.lat || 0;
        let lon = req.body.lon || 0;
        let LOCATION = req.body.LOCATION || "";
        let property_type = req.body.property_type || "";
        let TRANSACTION = req.body.TRANSACTION || "";
        let SALE_TERMS = req.body.SALE_TERMS || "";
        let SALE_PRICE = req.body.SALE_PRICE || 0;
        let RENT_PRICE = req.body.RENT_PRICE || 0;
        let COMMON_CHARGES = req.body.COMMON_CHARGES || 0;
        let DECORATION_STYLE = req.body.DECORATION_STYLE || "";
        let BEDROOMS = req.body.BEDROOMS || 0;
        let BATHROOMS = req.body.BATHROOMS || 0;
        let DIRECTION_OF_ROOM = req.body.DIRECTION_OF_RO || "";
        let UNIT_SIZE = req.body.UNIT_SIZE || 0;
        let LAND_AREA = req.body.LAND_AREA || 0;
        let INROOM_FACILITIES = req.body.INROOM_FACILITI || "";
        let PUBLIC_FACILITIES = req.body.PUBLIC_FACILITI || "";
        let image_01 = "";
        let image_02 = "";
        let image_03 = "";
        let image_04 = "";
        let image_05 = "";
        if (req.files.image > 1) image_01 = req.files.image[0].originalname;
        if (req.files.image > 1) image_02 = req.files.image[1].originalname;
        if (req.files.image > 2) image_03 = req.files.image[2].originalname;
        if (req.files.image > 3) image_04 = req.files.image[3].originalname;
        if (req.files.image > 4) image_05 = req.files.image[4].originalname;

        if (!canUseFile[0]) image_01 = "";
        if (!canUseFile[1]) image_02 = "";
        if (!canUseFile[2]) image_03 = "";
        if (!canUseFile[3]) image_04 = "";
        if (!canUseFile[4]) image_05 = "";


        let sqlCheck = `UPDATE 
        w701_test_properties  SET 
        real_estate_name =?,
        lat =?,
        lon =?,
        LOCATION = ?,
        property_type = ?,
        TRANSACTION = ?,
        SALE_TERMS = ?,
        SALE_PRICE = ?,
        RENT_PRICE = ?,
        COMMON_CHARGES = ?,
        DECORATION_STYLE = ?,
        BEDROOMS = ?,
        BATHROOMS = ?,
        DIRECTION_OF_ROOM = ?,
        UNIT_SIZE = ?,
        LAND_AREA = ?,
        INROOM_FACILITIES = ?,
        PUBLIC_FACILITIES = ?,
        image_01 = ?,
        image_02 = ?,
        image_03 = ?,
        image_04 = ?,
        image_05 = ? 
        WHERE id =?`;


        con.query(sqlCheck, [real_estate_name,
            lat,
            lon,
            LOCATION,
            property_type,
            TRANSACTION,
            SALE_TERMS,
            SALE_PRICE,
            RENT_PRICE,
            COMMON_CHARGES,
            DECORATION_STYLE,
            BEDROOMS,
            BATHROOMS,
            DIRECTION_OF_ROOM,
            UNIT_SIZE,
            LAND_AREA,
            INROOM_FACILITIES,
            PUBLIC_FACILITIES,
            image_01,
            image_02,
            image_03,
            image_04,
            image_05,
            id
        ], (err, results, fields) => {
            if (err) throw err;
            res.redirect("/dashboard/property")
        });
    } else {
        res.redirect('/login');
    }
});




app.listen(8080, () => {
    console.log("Start!!");
});