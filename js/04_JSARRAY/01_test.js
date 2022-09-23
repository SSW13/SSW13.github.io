const fs = require("fs");

let p = {
    name: "ssw",
    surname: "TNK",
    phone: "088888"
}

function PToString(p) {
    return p.name + "\r\n" + p.surname + "\r\n" + p.phone;
}

const data = new Uint8Array(Buffer.from(PToString(p)));
fs.appendFile('message.txt', data, (err) => {
    if (err) throw err;
    console.log('The file has been saved!');
});