const { Worker } = require("worker_threads");
const http = require("http");
const url = require("url");
//const { fork } = require("child_process");

const port = 9000;

http
  .createServer((req, res) => {
    const num = url.parse(req.url, true).query.n;

    const worker = new Worker("./worker.js", { workerData: { num } });
    worker.on("message", result => {
      const obj = { fib: result };

      res.end(JSON.stringify(obj));
    });
  })
  .listen(port);
