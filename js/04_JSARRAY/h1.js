const readline = require("readline");
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let x = [];

rl.on("line", (n) => {
    x.push(n);
    if (x.length >= 10) {
        let even = false;
        let i = 0;
        while (i < x.length) {
            if (x[i] % 2 == 0) {
                even = true;
                break;
            }
            i++;
        }
        if (even) {
            console.log("have");
        } else {
            console.log("Dont have");
        }
        rl.close();
    }
});