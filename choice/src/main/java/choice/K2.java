package choice;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;

public class K2 extends Team {

	public static int COMMUNICATION_PORT = 9495;
	
	public K2() {
		super("k2");
		initCommunicationChannel();
	}

	public void initCommunicationChannel() {
		Vertx vertx = Vertx.vertx();
		HttpServer server = vertx.createHttpServer();
		server.requestHandler(request -> {
			if (HttpMethod.PUT.equals(request.method())) {
				int priority = Thread.NORM_PRIORITY;
				try {
					priority = Integer.parseInt(request.getParam("priority"));
					// change priority
					oracle.setPriority(priority);
				} catch (Exception e) {}
				System.out.println("set priority " + priority);
				request.response().end("send success");
			}
		});
		server.listen(COMMUNICATION_PORT);
	}
	
}
