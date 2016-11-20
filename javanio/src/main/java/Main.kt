
import http.HttpHandler.Companion.httpHandler
import http.NioHttpServer
import java.lang.Runtime.getRuntime

/**
 * @author Ilya Sadykov
 */
val BODY = "Hello, World!"
val RESPONSE = "HTTP/1.1 200 OK\r\n" +
        "Content-Type: text/plain\r\n" +
        "Content-Length: 12\r\n\r\n$BODY"

fun main(args: Array<String>) {
    NioHttpServer(
            port = 8080,
            threadsCount = getRuntime().availableProcessors(),
            httpHandler = httpHandler { req, writer -> writer.write(RESPONSE) }
    ).run()
}