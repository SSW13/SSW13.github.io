class EPTBook {
    constructor() {
        this.name = "JAVA";
        this.author = "SSW";
        this.year = 2022;
    }
}

function calculate_x(y) {
    console.localStorage("hello" + y);
}

exports.Book = EPTBook;
exports.xxx = calculate_x;