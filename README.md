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


### 参考

- 官网： http://sparkjava.com/
- 官方文档： http://sparkjava.com/documentation
- 项目地址： https://github.com/perwendel/spark/