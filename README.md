# spark-java-framework-demo

*spring-boot + spark-java-framework*

启动spring-boot项目之后访问 http://127.0.0.1:4567/hello 可查看效果.

### 1. Spark简介
Spark —— 用于Kotlin和Java 8以最低消耗创建Web应用程序的微框架。

快速开始：

**Java:**

```java

import static spark.Spark.*;

public class HelloWorld {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
    }
}
```

**Kotlin**

```kotlin
import spark.kotlin.*

fun main(args: Array<String>) {
    val http: Http = ignite()

    http.get("/hello") {
        "Hello Spark Kotlin!"
    }
}
```

运行查看：

```
http://localhost:4567/hello
```

**为生产效率而生**

Spark Framework是一个简单而富有表现力的Java/Kotlin Web框架，是为快速开发而构建的DSL（领域专用语言，domain specific language / DSL）。Spark的目的是为Kotlin/Java开发人员提供一种替代方案，以便开发他们的web应用程序时，尽可能有表达更多的内容和使用最少的样板。
凭借明确的理念，Spark的设计不仅让你的工作更富有成效，而且可以在Spark的流畅性，声明性以及丰富表达式的影响下，让你的代码更好。

**你可以充分利用JVM**

JVM提供了世界上最大的编程生态系统之一。虽然它有很多Java的web框架，但是纯Java的web开发传统意义上都是非常麻烦的。若你热爱JVM，但是憎恨累赘的代码和框架，那么Spark就是你专属的web框架。它可以几分钟内启动并运行，而且你可以在Groovy或者Kotlin或者其他任何你使用的语言中使用。
Spark是一个有着丰富表达的，轻量级且开放的纯Java（和Kotlin）web框架，与其他框架不同，你可以按你所想构建应用程序。

**微服务，到处都是微服务！！！**

2015年是微服务爆火的一年，现在你若开始研究微服务，你会意识到Spark对于微服务非常棒。微服务在微框架下运行得最好，而且Spark可以用少于十行代码构建你的REST API服务于JSON。
虽说Spark主要用于创建REST API，但它也支持多种模板引擎。为何不为你的后端创建一个Spark应用程序，并且为你的前端创建一个呢？

**NodeJS开发者？用TypeScript？试试Spark替代吧！**

后来，很多服务端的web开发已被NodeJS接管，但越来越多的NodeJS开发人员正使用TypeScript以及其他编译为JavaScript的静态类型语言。为什么不完全一致呢，去使用实际上是用类型设计的，且打算在服务器端运行的语言？
你还可以获得在JVM上运行应用程序的所有好处，其中类库亦不会天天被弃用。
如果你转自ExpressJS，那么对于Spark的语法将会非常熟悉，并且与许多JavaScript web框架不同，Spark在未来并不会过时。

**典型用途**

我们的2015年调查告诉我们，超过50％的Spark用户使用Spark创建REST API，而大约25％使用Spark创建网站。大约15％的Spark应用程序每天服务于超过10,000个用户。点击[此处](http://sparkjava.com/news#sparksurvey)阅读完整调查。

### 2. 代码示例

#### Getting started
当前版本为2.7.1，更多版本可以参见[releases](https://github.com/perwendel/spark/releases)

`compile group: 'com.sparkjava', name: 'spark-core', version: '2.7.1'`

```java
public class SparkJavaApplication {
  public static void main(String[] args) {
    get("/hello", (req, res) -> "Hello World");
  }
}
```

#### 更多例子

```java
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
    
    get("/hello2", "application/json", (request, response) -> { 
      return "{\"message\": \"Hello World\"}";
    });
  }
}

```
你可以使用port()函数定义开启的端口。
同时Spark参数的传递是以`:param`的形式传递的，获取方式同样是常用的request.params("paramName")。
在定义接口的时候还可以定义接口接收的类型，比如"application/json"。

此外，除了get方法，其他比如post、put等方法如下例所示：

```java
public class Books {

  /**
   * Map holding the books
   */
  public static Map<String, Book> books = new HashMap<>();

  // Creates a new book resource, will return the ID to the created resource
  // author and title are sent as query parameters e.g. /books?author=Foo&title=Bar
  public static void main(String[] args) {
    post("/books", (request, response) -> {
      String author = request.queryParams("author");
      String title = request.queryParams("title");
      Book book = new Book(author, title);
      Random random = new Random();
      int id = random.nextInt(Integer.MAX_VALUE);
      books.put(String.valueOf(id), book);

      response.status(201); // 201 Created
      return id;
    });

    // Gets the book resource for the provided id
    get("/books/:id", (request, response) -> {
      Book book = books.get(request.params(":id"));
      if (book != null) {
        return "Title: " + book.getTitle() + ", Author: " + book.getAuthor();
      } else {
        response.status(404); // 404 Not found
        return "Book not found";
      }
    });

    // Updates the book resource for the provided id with new information
    // author and title are sent as query parameters e.g. /books/<id>?author=Foo&title=Bar
    put("/books/:id", (request, response) -> {
      String id = request.params(":id");
      Book book = books.get(id);
      if (book != null) {
        String newAuthor = request.queryParams("author");
        String newTitle = request.queryParams("title");
        if (newAuthor != null) {
          book.setAuthor(newAuthor);
        }
        if (newTitle != null) {
          book.setTitle(newTitle);
        }
        return "Book with id '" + id + "' updated";
      } else {
        response.status(404); // 404 Not found
        return "Book not found";
      }
    });

    // Deletes the book resource for the provided id
    delete("/books/:id", (request, response) -> {
      String id = request.params(":id");
      Book book = books.remove(id);
      if (book != null) {
        return "Book with id '" + id + "' deleted";
      } else {
        response.status(404); // 404 Not found
        return "Book not found";
      }
    });

    // Gets all available book resources (id's)
    get("/books", (request, response) -> {
      StringBuilder ids = new StringBuilder();
      for (String id : books.keySet()) {
        ids.append(id).append(" ");
      }
      return ids.toString();
    });

  }
}
```

更多例子可以参考[github项目](https://github.com/perwendel/spark/)


### 总结

Spark 是一个非常轻量级的web框架，若你不需要那么多的功能，只是提供简单的web接口，那么Spark是个非常适合的选择。另外，Spark同样适用于微服务的架构，它的功能不止于此，若是有兴趣，可以自行探索。
本文只是一篇引子，为的是我不用再引用所占内存较大Spring的web的框架，项目启动速度飞升。

### 参考

- 官网： http://sparkjava.com/
- 官方文档： http://sparkjava.com/documentation
- 项目地址： https://github.com/perwendel/spark/