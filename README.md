# Just for fun
Benchmarking the simple "Hello, World!" apps with different web frameworks using different platforms.

## Hardware configuration

Tests performed just on my laptop

Macbook Pro 2015 (Intel(R) Core(TM) i5-4278U CPU @ 2.60GHz 8GB RAM)

Ubuntu 14.04 Linux 4.4.0-30-generic

## Benchmarking tool
I used tiny benchmark tool written on Crystal [Cryload](https://github.com/sdogruyol/cryload)

## Results

### Totals:
```
------------------------------------------------------------
| Framework             |  RPS  |  Max    |  Min   |  Avg  |
|----------------------------------------------------------|
| Undertow (Java)       | 23911 | 43.188  | 0.021  | 0.042 |
| Undertow (Groovy)     | 23195 | 106.725 | 0.021  | 0.043 |
| Mux      (Go)         | 13927 | 63.014  | 0.036  | 0.072 |
| Kemal    (Crystal)    | 12823 | 8.429   | 0.036  | 0.078 |
| Expressjs (Javascript)| 8505  | 8.966   | 0.084  | 0.118 |
| Ratpack  (Groovy)     | 6889  | 48.397  | 0.06   | 0.145 |
| Goji     (Go)         | 2212  | 67.928  | 0.048  | 0.452 |
------------------------------------------------------------
```

### (Groovy) Ratpack:
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
Min: 0.06 ms
Max: 48.397 ms
Average: 0.145 ms

Requests Statistics:
Request p/s: 6889.7002261122443
2xx requests 0
Non 2xx requests 100000
Total request made: 100000
Total time taken: 14.51441959999884 seconds
```


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
Min: 0.048 ms
Max: 67.928 ms
Average: 0.452 ms

Requests Statistics:
Request p/s: 2212.9186744487088
2xx requests 0
Non 2xx requests 100000
Total request made: 100000
Total time taken: 45.189188899999863 seconds
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
Min: 0.036 ms
Max: 63.014 ms
Average: 0.072 ms

Requests Statistics:
Request p/s: 13927.276525116038
2xx requests 0
Non 2xx requests 100000
Total request made: 100000
Total time taken: 7.1801546999991679 seconds
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
Max: 8.429 ms
Average: 0.078 ms

Requests Statistics:
Request p/s: 12823.732892724562
2xx requests 0
Non 2xx requests 100000
Total request made: 100000
Total time taken: 7.7980413999993843 seconds
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
Min: 0.021 ms
Max: 43.188 ms
Average: 0.042 ms

Requests Statistics:
Request p/s: 23911.768253264065
2xx requests 0
Non 2xx requests 100000
Total request made: 100000
Total time taken: 4.1820411999999019 seconds
```

### (Groovy) Undertow: 
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
Min: 0.021 ms
Max: 106.725 ms
Average: 0.043 ms

Requests Statistics:
Request p/s: 23195.92046851839
2xx requests 0
Non 2xx requests 100000
Total request made: 100000
Total time taken: 4.3111029000000434 seconds
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
Min: 0.084 ms
Max: 8.966 ms
Average: 0.118 ms

Requests Statistics:
Request p/s: 8505.8648788923983
2xx requests 0
Non 2xx requests 100000
Total request made: 100000
Total time taken: 11.756594000000341 seconds
```
