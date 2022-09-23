let req = { name: "ssw", phone: "000000" };

Object.keys(req).forEach((prop) => console.log(prop));

for (const [key, value] of Object.entries(req)) {
    console.log(key, value);
}

console.log(req.constructor.name);

////////////////////////////////

class Person {
    constructor(nnn, sss, ppp) {
        this.name = nnn;
        this.surname = sss;
        this.phone = ppp;
    }

}

let xxx = new Person("SSW", "TNK", "00000");


Object.keys(xxx).forEach((prop) => console.log(prop));

for (const [key, value] of Object.entries(xxx)) {
    console.log(key, value);
}

console.log(xxx.constructor.name);