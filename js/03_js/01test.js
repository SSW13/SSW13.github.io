var http = require('http');
const port = 8080;
const hostname = "127.0.0.1";
http.createServer(function(req, res) {
    res.writeHead(200, { 'Content-Type': 'text/plain' });
    res.write('Hello World!');
    res.end();
}).listen(port, hostname, () => {
    console.log(`server is running... on http://${hostname}:${port}`);
});