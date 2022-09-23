// app.get('/', (req, res) => {
//     res.writeHead(200, { 'Content-Type': 'text/html' });
//     res
//     for (let i = 0; i < 100; i++) {
//         res.write("hello</br>\n");
//     }
//     res.end();
// });


const express = require('express');
const path = require('path');
const app = express();
const baseURL = "http://localhost";
const port = 8080;
const url = require('url');
const querystring = require('node:querystring');


let option = {
    root: path.join(__dirname, '/')
}

app.get('/', (req, res) => {
    res.sendFile("home.html", option);
});

app.get('/about', (req, res) => {
    res.sendFile("about.html", option);
});

app.get('/bmi', (req, res) => {
    res.sendFile("bmi.html", option);
});

app.get('/bmi_cal', (req, res) => {
    let xCurrentURL = new url.URL(req.url, baseURL + ":" + port);
    res.writeHead(200, { 'Content-Type': 'text/html' });

    if (xCurrentURL.searchParams.get("submit") == null) {
        res.end("Please input your weigth and heigth </br>" +
            "<a href = '/bmi'>BMI</a>");
    } else {
        let w = xCurrentURL.searchParams.get("weigth");
        let h = xCurrentURL.searchParams.get("heigth");
        let bmi = w / Math.pow((h / 100), 2);
        res.write("<img src= '/xxx.jpg' alt='abc' width='200' />");
        res.end("Your BMI is " + bmi);
    }
});
app.post('/bmi_cal', (req, res) => {
    let data = "";
    req.on("data", chunk => {
        data += chunk;
    });
    req.on("end", () => {
        console.log(data);
        let input = querystring.parse(data);
        console.log(input.weigth);
        console.log(input.heigth);
        console.log(input.submit);
        let bmi = input.weigth / Math.pow((input.heigth / 100), 2);
        res.setHeader("Content-Type", "text/html");
        res.write("<img src= '/xxx.jpg' alt='abc' width='200' />");
        res.end("Your BMI is " + bmi);

        res.end();
    })
});


app.use(express.static('public'));
app.listen(port, () => {
    console.log("Server is running...")
});