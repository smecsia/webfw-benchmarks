# Just for fun
Benchmarking the simple "Hello, World!" apps with different web frameworks using different platforms.

## Hardware configuration

Tests performed just on my laptop

Macbook Pro 2015 (Intel(R) Core(TM) i5-4278U CPU @ 2.60GHz 8GB RAM)

Ubuntu 16.04 Linux 4.4.0-36-generic

* JDK v1.8.0_101
* Go 1.6.2
* Crystal 0.19.0
* Nodejs 6.2.2


* Undertow 1.4.0.CR3
* Ratpack 1.4.1
* Expressjs 4.13.1
* Kemal [b00bc](https://github.com/sdogruyol/kemal/commit/b00bc7a202ce4b715538ad030dbb843c1c893368)
* Gin [f931d](https://github.com/gin-gonic/gin/commit/f931d1ea80ae95a6fc739213cdd9399bd2967fb6)
* Mux [0a192](https://github.com/gorilla/mux/commit/0a192a193177452756c362c20087ddafcf6829c4)
* Goji [bc2e9](https://github.com/goji/goji/commit/bc2e9e7dc2769805d1b6ce4dc48ec23a03ae82ec)

## Benchmarking tool
I used tiny benchmark tool written on Crystal [Cryload](https://github.com/sdogruyol/cryload)

## Results

### Totals:
| Framework             |  RPS  |  Max    |  Min   |  Avg  |
| :-------------------- | ----: | ------: | -----: | ----: |
| Undertow (Java)       | 29728 | 84.218  | 0.018  | 0.034 |
| Kemal    (Crystal)    | 17684 | 5.731   | 0.036  | 0.057 |
| Gin      (Go)         | 17647 | 7.667   | 0.030  | 0.057 |
| Mux      (Go)         | 17435 | 5.344   | 0.036  | 0.057 |
| Goji     (Go)         | 16733 | 4.723   | 0.032  | 0.060 |
| Ratpack  (Java)       | 10712 | 81.258  | 0.053  | 0.093 |
| Expressjs (Javascript)| 9425  | 31.582  | 0.080  | 0.106 |

### (Go) Goji:
```
$ ./cryload -s http://localhost:8000 -n 100000
Preparing to make it CRY for 100000 requests!
Total request made: 10000
Total request made: 20000
Total request made: 30000
Total request made: 40000
Total request made: 50000
Total request made: 60000
Total request made: 70000
Total request made: 80000
Total request made: 90000
Completed All Requests!
-------------------------------

Time taken per request:
Min: 0.032 ms
Max: 4.723 ms
Average: 0.06 ms

Requests Statistics:
Request p/s: 16733.642233023791
2xx requests 0
Non 2xx requests 100000
Total request made: 100000
Total time taken: 5.9759852999994409 seconds
```

### (Go) Gin:
```
$ ./cryload -s http://localhost:8080 -n 100000
Preparing to make it CRY for 100000 requests!
Total request made: 10000
Total request made: 20000
Total request made: 30000
Total request made: 40000
Total request made: 50000
Total request made: 60000
Total request made: 70000
Total request made: 80000
Total request made: 90000
Completed All Requests!
-------------------------------

Time taken per request:
Min: 0.03 ms
Max: 7.667 ms
Average: 0.057 ms

Requests Statistics:
Request p/s: 17647.044394477816
2xx requests 0
Non 2xx requests 100000
Total request made: 100000
Total time taken: 5.6666712999992459 seconds
```

### (Go) Mux:
```
$ ./cryload -s http://localhost:8000 -n 100000
Preparing to make it CRY for 100000 requests!
Total request made: 10000
Total request made: 20000
Total request made: 30000
Total request made: 40000
Total request made: 50000
Total request made: 60000
Total request made: 70000
Total request made: 80000
Total request made: 90000
Completed All Requests!
-------------------------------

Time taken per request:
Min: 0.031 ms
Max: 5.344 ms
Average: 0.057 ms

Requests Statistics:
Request p/s: 17435.047517567575
2xx requests 0
Non 2xx requests 100000
Total request made: 100000
Total time taken: 5.7355736999993772 seconds
```


### (Crystal) Kemal:
```
$ ./cryload -s http://localhost:3000 -n 100000
Preparing to make it CRY for 100000 requests!
Total request made: 10000
Total request made: 20000
Total request made: 30000
Total request made: 40000
Total request made: 50000
Total request made: 60000
Total request made: 70000
Total request made: 80000
Total request made: 90000
Completed All Requests!
-------------------------------

Time taken per request:
Min: 0.036 ms
Max: 5.731 ms
Average: 0.057 ms

Requests Statistics:
Request p/s: 17684.628985593281
2xx requests 0
Non 2xx requests 100000
Total request made: 100000
Total time taken: 5.654628099999421 seconds
```

### (Java) Undertow: 
```
$ ./cryload -s http://localhost:8080 -n 100000
Preparing to make it CRY for 100000 requests!
Total request made: 10000
Total request made: 20000
Total request made: 30000
Total request made: 40000
Total request made: 50000
Total request made: 60000
Total request made: 70000
Total request made: 80000
Total request made: 90000
Completed All Requests!
-------------------------------

Time taken per request:
Min: 0.018 ms
Max: 84.218 ms
Average: 0.034 ms

Requests Statistics:
Request p/s: 29728.258743355655
2xx requests 0
Non 2xx requests 100000
Total request made: 100000
Total time taken: 3.3638027999991849 seconds
```

### (Javascript) Expressjs: 
```
$ ./cryload -s http://localhost:3000 -n 100000
Preparing to make it CRY for 100000 requests!
Total request made: 10000
Total request made: 20000
Total request made: 30000
Total request made: 40000
Total request made: 50000
Total request made: 60000
Total request made: 70000
Total request made: 80000
Total request made: 90000
Completed All Requests!
-------------------------------

Time taken per request:
Min: 0.08 ms
Max: 31.582 ms
Average: 0.106 ms

Requests Statistics:
Request p/s: 9425.6656332016664
2xx requests 0
Non 2xx requests 100000
Total request made: 100000
Total time taken: 10.609330300000519 seconds
```

### (Java) Ratpack:
```
$ ./cryload -s http://localhost:8080 -n 100000
Preparing to make it CRY for 100000 requests!
Total request made: 10000
Total request made: 20000
Total request made: 30000
Total request made: 40000
Total request made: 50000
Total request made: 60000
Total request made: 70000
Total request made: 80000
Total request made: 90000
Completed All Requests!
-------------------------------

Time taken per request:
Min: 0.053 ms
Max: 81.258 ms
Average: 0.093 ms

Requests Statistics:
Request p/s: 10712.561451002208
2xx requests 0
Non 2xx requests 100000
Total request made: 100000
Total time taken: 9.3348355999997121 seconds
```
