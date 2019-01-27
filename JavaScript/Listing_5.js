const { Worker, isMainThread,  workerData } = require('worker_threads');

function fibonacci(n) {
    if (n <= 1) {
        return n;
    } else {
        return fibonacci(n - 1) +
                fibonacci(n - 2);
    }
}

function fibonacciWorker(n) {
    return new Promise((resolve, reject) => {
        const worker = new Worker(__filename,  {workerData: n});
        worker.on('exit', resolve);
    });
}

if (isMainThread) {
    let w1 = fibonacciWorker(40);
    console.log("1");
    let w2 = fibonacciWorker(45);
    console.log("2");
    Promise.all([
        w1, w2
      ]).then(() => {
        console.log("Fertig")
    });
} else {
    console.log(`Berechne fib(${workerData})`);
    console.log(`fib(${workerData}) = ${fibonacci(workerData)}`);
}