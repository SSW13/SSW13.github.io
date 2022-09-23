const http = require("http");

let listerner = function(req, res) {
    res.writeHead(200);
    res.write('Hello aaa!');
    res.end();
}

const server = http.createServer(listerner);
server.listen(8080);