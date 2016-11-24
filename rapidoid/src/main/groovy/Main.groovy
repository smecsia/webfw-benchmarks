import groovy.transform.CompileStatic

/**
 * @author Ilya Sadykov
 */
@CompileStatic
class Main {
    static void main(String[] args) {
        new CustomHttpServer().listen(8080)
    }
}
