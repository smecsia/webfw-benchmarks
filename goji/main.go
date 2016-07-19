package main

import (
	"io"
	"net/http"
	"github.com/zenazn/goji"
)

func main() {
	goji.Get("/", Root)
	goji.Serve()
}

func Root(w http.ResponseWriter, r *http.Request) {
	io.WriteString(w, "Hello,World!")
}
