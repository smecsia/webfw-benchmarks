package main

import (
	"fmt"
	"net/http"
	"goji.io"
	"goji.io/pat"
	"golang.org/x/net/context"
)


func hello(ctx context.Context, w http.ResponseWriter, r *http.Request) {
	fmt.Fprint(w, "Hello, World!")
}

func main() {
	mux := goji.NewMux()
	mux.HandleFuncC(pat.Get("/hello"), hello)

	http.ListenAndServe("localhost:8000", mux)
}
