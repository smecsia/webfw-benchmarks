import groovy.transform.CompileStatic

import static io.undertow.Undertow.builder
import static io.undertow.util.Headers.CONTENT_TYPE
/**
 * @author Ilya Sadykov
 */
@CompileStatic
class Main {
    public static void main(String[] args) {
        builder().addHttpListener(8080, "localhost").setHandler({
            it.responseHeaders.put(CONTENT_TYPE, "text/plain")
            it.responseSender.send("Hello World")
        }).build().start();
    }
}
