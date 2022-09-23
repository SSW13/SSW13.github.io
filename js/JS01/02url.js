const url = require('url');

let xURL = new url.URL('https://user:pass@sub.example.com:8080/p/a/t/h?query=string&x=1&y=2#hassh');
console.log("hash :" + xURL.hash);
console.log("href :" + xURL.href);
console.log("protocol :" + xURL.protocol);
console.log("port :" + xURL.port);
console.log("pathname :" + xURL.pathname);
console.log("searchParams :" + xURL.searchParams);
console.log("searchParams.query :" + xURL.searchParams.get("query"));
console.log("searchParams.x :" + xURL.searchParams.get("x"));
console.log("searchParams.y :" + xURL.searchParams.get("y"));