import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import static spark.Spark.get;

/**
 * @author liuqian
 * @date 2018/3/19 22:54.
 */
@SpringBootApplication
@EntityScan(basePackageClasses = {SparkJavaApplication.class})
public class SparkJavaApplication {

  public static void main(String[] args) {
    get("/hello", (req, res) -> "Hello World");
  }
}
