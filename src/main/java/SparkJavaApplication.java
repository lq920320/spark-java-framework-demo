import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import static spark.Spark.get;
import static spark.Spark.halt;
import static spark.Spark.port;

/**
 * @author liuqian
 * @date 2018/3/19 22:54.
 */
@SpringBootApplication
@EntityScan(basePackageClasses = {SparkJavaApplication.class})
public class SparkJavaApplication {

  public static void main(String[] args) {
    port(4567);
    get("/hello", (req, res) -> "Hello World");

    get("/users/:name", (request, response) -> "Selected user: " + request.params(":name"));

    get("/news/:section", (request, response) -> {
      response.type("text/xml");
      return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><news>" + request.params("section") + "</news>";
    });

    get("/protected", (request, response) -> {
      halt(403, "I don't think so!!!");
      return null;
    });

    get("/redirect", (request, response) -> {
      response.redirect("/news/world");
      return null;
    });

    get("/", (request, response) -> "root");
  }
}
