const http = require('http');
const fs = require('fs');
const url = require('url');
const baseURL = "http://localhost";
const port = 8080;
const httpCallBackFunc = function(req, res) {

    let xCurrentURL = new url.URL(req.url, baseURL + ":" + port);
    console.log(xCurrentURL.toString());

    if (xCurrentURL.pathname == "/") {
        fs.readFile("./home.html", function(err, data) {
            if (err) throw err;
            res.writeHead(200, { 'Content-Type': 'text/html' });
            res.write(data.toString());
            res.end("");

        });
    } else if (xCurrentURL.pathname == "/about") {
        fs.readFile("./about.html", function(err, data) {
            if (err) throw err;
            res.writeHead(200, { 'Content-Type': 'text/html' });
            res.write(data.toString());
            res.end("");

        });
    } else if (xCurrentURL.pathname == "/bmi") {
        fs.readFile("./bmi.html", function(err, data) {
            if (err) throw err;
            res.writeHead(200, { 'Content-Type': 'text/html' });
            res.write(data.toString());
            res.end("");

        });
    } else if (xCurrentURL.pathname == "/bmi_cal") {
        res.writeHead(200, { 'Content-Type': 'text/html' });

        if (xCurrentURL.searchParams.get("submit") == null) {
            res.end("Please input your weigth and heigth </br>" +
                "<a href = '/bmi'>BMI</a>");
        } else {
            let w = xCurrentURL.searchParams.get("weigth");
            let h = xCurrentURL.searchParams.get("heigth");
            let bmi = w / Math.pow((h / 100), 2);
            res.end("Your BMI is " + bmi);
        }

    } else if (xCurrentURL.pathname.indexOf("/public/") == 0) {
        let fileExist = fs.existsSync("." + xCurrentURL.pathname);
        if (fileExist) {
            fs.readFile("." + xCurrentURL.pathname, function(err, data) {
                if (err) throw err;
                res.writeHead(200, { 'Content-Type': 'image/jpeg' });
                //res.write(data);
                res.end(data);

            });
        }
    } else {
        res.writeHead(404);
        res.end();
    }


}

const server = http.createServer(httpCallBackFunc);
server.listen(port);