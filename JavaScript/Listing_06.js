function* fibonacciGenerator() {
    [first, second] = [1, 1]
    while (true) {
        yield first;
        [first, second] = [second, first + second]
    }
}

function fibonacciPromise(n) {
    return new Promise((resolve, reject) => {
        let gen = fibonacciGenerator();
        console.log(`Berechne fib(${n})`);
        for (i = 1; i < n; i++) {
            gen.next();
        }
        console.log(`fib(${n}) = ${gen.next().value}`);
        resolve();
    });
}

let w1 = fibonacciPromise(40);
console.log("1");
let w2 = fibonacciPromise(45);
console.log("2");
Promise.all([
    w1
]).then(() => {
    console.log("Fertig")
});