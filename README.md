This poject contains example of using [Spring Webflux](https://docs.spring.io/spring-framework/docs/5.0.0.BUILD-SNAPSHOT/spring-framework-reference/html/web-reactive.html).

Webflux is :
* a non-blocking approach which makes it possible to handle concurrency 
with a small number of threads and to scale effectively.
* functional programming, which helps write more declarative code 
with the usage of fluent APIs.

There are four indicators that migration to WebFlux could be a good idea for the project:
* Current technology stack doesn’t solve the problem with adequate performance and scalability.
* There are a lot of calls to external services or databases with possibly slow responses.
* Existing blocking dependencies could be easily replaced with reactive ones.
* The development team is open to new challenges and willing to learn.

Blocking APIs and WebFlux are not the best friends. 
They can cooperate, but there is no efficiency gain from migration to reactive stack. You should take this advice with a grain of salt. 
When only some dependencies in your code are blocking — there are elegant ways to deal with it. 
When they are the majority — your code becomes much more complicated and error-prone — one blocking call can lock the whole application.

You can find more information about migration to Webflux at https://allegro.tech/2019/07/migrating-microservice-to-spring-webflux.html.

In this project you can find two endpoints:
1) `/hello-webflux` which uses blocking `HelloWorldWebfluxService` under the hood
2) `/hello-webflux-http` which calls `/hello-webflux` via non-blocking HTTP client.

Pay attention to result types of `HelloWorldWebfluxController`: they return reactive types `Mono` and `Flux`.
You can read about reactive types here: https://spring.io/blog/2016/04/19/understanding-reactive-types

Please find an example of usage of non-blocking HTTP client in `com.inventale.project.webflux.services.NonBlockingHttpClientService.getHelloWorld`.

As was described above, you should avoid blocking calls like `Thread.sleep()` whenever you can.
If you can rewrite your code there are ways to use blocking API, see `com.inventale.project.webflux.services.ExternalService.getHelloWorld` 
for example.


*** How to start application ***
1) Run `HelloWorldWebfluxApplication`
2) Open `http://localhost:8091/hello-webflux-http` in your browser (or curl) to get result via non-blocking HTTP client
3) Open `http://localhost:8091/hello-webflux` to get result from service with blocking code.

