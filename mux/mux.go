package main

import (
	"net/http"
	"github.com/gorilla/mux"
	"log"
)

func main() {
	r := mux.NewRouter()
	r.HandleFunc("/", HelloHandler)
	// Bind to a port and pass our router in
	log.Fatal(http.ListenAndServe(":8080", r))
}

func HelloHandler(w http.ResponseWriter, r *http.Request) {
	w.Write([]byte("Hello,World!"))
}

