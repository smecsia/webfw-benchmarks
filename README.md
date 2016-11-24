# Just for fun
Benchmarking the simple "Hello, World!" web apps with different web frameworks using different platforms.

## Hardware configuration

Tests performed on my laptop

MacBookPro11,5 (Intel(R) Core(TM) i7-4870HQ CPU @ 2.50GHz 16GB RAM)

Ubuntu 16.04 Linux 4.4.0-47-generic

* Oracle JDK v1.8.0_111
* Go 1.6.2
* Crystal 0.19.4
* Nodejs 7.1.0

* Rapidoid 5.2.6
* Undertow 1.4.4.Final
* Expressjs 4.14.0
* Tomcat 7.0.59
* Avian [01e11](https://github.com/ReadyTalk/avian/commit/01e11d8230a9e9e04d7019880bb090fdec92be27)
* Kemal [73358](https://github.com/sdogruyol/kemal/commit/733582f7243a415d345bdaefc4e9df16e949c3b2)
* Gin [bb159](https://github.com/gin-gonic/gin/commit/bb159f9260a262fccbdbd6f37f8575d1e7e6aaa0)
* Mux [757be](https://github.com/gorilla/mux/commit/757bef944d0f21880861c2dd9c871ca543023cba)
* Echo [cd253](https://github.com/labstack/echo/commit/cd2530ea098106338b888f4fb66e966efa2fd75e)

## Benchmarking tool
I used tiny benchmark tool written on Crystal [Cryload](https://github.com/sdogruyol/cryload)

## Results

### Totals:
| Framework             |  RPS  |  Max    |  Min   |  Avg  |
| :-------------------- | ----: | ------: | -----: | ----: |
| Undertow (Java)       | 49038 | 1.574   | 0.017  | 0.020 |
| java.nio (Java)       | 48277 | 6.945   | 0.014  | 0.021 |
| Rapidoid (Java)       | 47044 | 1.781   | 0.016  | 0.021 |
| Kemal    (Crystal)    | 41561 | 1.506   | 0.018  | 0.024 |
| java.nio (Avian)      | 29657 | 3.260   | 0.019  | 0.034 |
| Gin      (Go)         | 28390 | 2.957   | 0.026  | 0.035 |
| Mux      (Go)         | 26588 | 2.999   | 0.028  | 0.038 |
| Echo     (Go)         | 19688 | 6.558   | 0.027  | 0.051 |
| Servlet  (Java)       | 16869 | 8.546   | 0.059  | 0.059 |
| Expressjs (Javascript)| 12030 | 2.742   | 0.068  | 0.083 |

### (Go) echo
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
Min: 0.027 ms
Max: 6.558 ms
Average: 0.051 ms

Requests Statistics:
Request p/s: 19688.098001367413
2xx requests 0
Non 2xx requests 100000
Total request made: 100000
Total time taken: 5.0792107999998075 seconds
```

### (Java) rapidoid

```
$ ./cryload -s http://localhost:8080/plaintext -n 100000
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
Min: 0.016 ms
Max: 1.781 ms
Average: 0.021 ms

Requests Statistics:
Request p/s: 47044.444533303096
2xx requests 0
Non 2xx requests 100000
Total request made: 100000
Total time taken: 2.1256495000001392 seconds
```

### (Java) plain java.nio.channels 

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
Min: 0.014 ms
Max: 6.945 ms
Average: 0.021 ms

Requests Statistics:
Request p/s: 48277.898397423458
2xx requests 0
Non 2xx requests 100000
Total request made: 100000
Total time taken: 2.0713412000000586 seconds
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
Min: 0.026 ms
Max: 2.975 ms
Average: 0.035 ms

Requests Statistics:
Request p/s: 28390.047800609238
2xx requests 0
Non 2xx requests 100000
Total request made: 100000
Total time taken: 3.5223610999997694 seconds
```

### (Java) java.nio - Avian JDK:
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
Min: 0.019 ms
Max: 3.26 ms
Average: 0.034 ms

Requests Statistics:
Request p/s: 29657.85512019254
2xx requests 0
Non 2xx requests 100000
Total request made: 100000
Total time taken: 3.371787999999873 seconds
```

### (Go) Mux:
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
Min: 0.028 ms
Max: 2.999 ms
Average: 0.038 ms

Requests Statistics:
Request p/s: 26588.521230202594
2xx requests 0
Non 2xx requests 100000
Total request made: 100000
Total time taken: 3.7610215 seconds
```


### (Crystal) Kemal:
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
Max: 1.506 ms
Average: 0.024 ms

Requests Statistics:
Request p/s: 41561.127378827761
2xx requests 0
Non 2xx requests 100000
Total request made: 100000
Total time taken: 2.4060945000000746 seconds
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
Min: 0.017 ms
Max: 1.574 ms
Average: 0.02 ms

Requests Statistics:
Request p/s: 49038.901285369313
2xx requests 0
Non 2xx requests 100000
Total request made: 100000
Total time taken: 2.0391974000003721 seconds
```

### (Javascript) Expressjs: 
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
Min: 0.068 ms
Max: 2.742 ms
Average: 0.083 ms

Requests Statistics:
Request p/s: 12030.976588535839
2xx requests 0
Non 2xx requests 100000
Total request made: 100000
Total time taken: 8.3118772000012608 seconds
```

### (Java) Servlet:
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
Min: 0.049 ms
Max: 8.546 ms
Average: 0.059 ms

Requests Statistics:
Request p/s: 16869.906015899727
2xx requests 0
Non 2xx requests 100000
Total request made: 100000
Total time taken: 5.9277152999993561 seconds
```
