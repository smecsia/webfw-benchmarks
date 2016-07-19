import ratpack.server.RatpackServer;

/**
 * @author Ilya Sadykov
 */
public class Main {
    public static void main(String[] args) throws Exception {
        RatpackServer.start(server -> server
                .serverConfig(cfg -> {
                    cfg.port(8080);
                    cfg.threads(200);
                })
                .handlers(chain ->
                        chain.get(ctx -> ctx.render("Hello World!"))
                )
        );
    }
}
