This poject contains example of using [Spring Webflux](https://docs.spring.io/spring-framework/docs/5.0.0.BUILD-SNAPSHOT/spring-framework-reference/html/web-reactive.html).

Webflux is :
* a non-blocking approach which makes it possible to handle concurrency 
with a small number of threads and to scale effectively.
* functional programming, which helps write more declarative code 
with the usage of fluent APIs.
* based on [Project Reactor](https://github.com/reactor/reactor-core)
Pay attention to the types:
    - `Mono` - A Reactive Streams Publisher constrained to ZERO or ONE element with appropriate operators.
    - `Flux` - A Reactive Streams Publisher with basic flow operators.

You can read about reactive types here: https://spring.io/blog/2016/04/19/understanding-reactive-types

## Project structure
1) `external-app` - an example of external service (`http://localhost:8090/hello`) to be used by our services
2) `backend-blocking-app` - contains the blocking service `http://localhost:8091/hello-blocking` 
which is written with Spring MVC and calls the HTTP endpoint from the `external-app`,   
3) `backend-non-blocking-app` - contains the non-blocking service `http://localhost:8092/hello-non-blocking` 
which is written with Spring Webflux and calls the HTTP endpoint from the `external-app`,   

## How to run an example
1) Run `ExternalApplication` from the `external-app`
2) Run `BlockingApplication` from the `backend-blocking-app`
3) Run `NonBlockingApplication` from the `backend-non-blocking-app`

After applications start you can see in logs something like:
```
31-08-2020 13:38:36.191 [http-nio-8091-exec-1] INFO  c.i.p.w.c.BlockingController.helloBlocking - BlockingController, the thread is http-nio-8091-exec-1
31-08-2020 13:38:36.191 [http-nio-8091-exec-3] INFO  c.i.p.w.c.BlockingController.helloBlocking - BlockingController, the thread is http-nio-8091-exec-3
31-08-2020 13:38:36.189 [http-nio-8091-exec-19] INFO  c.i.p.w.c.BlockingController.helloBlocking - BlockingController, the thread is http-nio-8091-exec-19
31-08-2020 13:38:36.191 [http-nio-8091-exec-11] INFO  c.i.p.w.c.BlockingController.helloBlocking - BlockingController, the thread is http-nio-8091-exec-11
31-08-2020 13:38:36.189 [http-nio-8091-exec-2] INFO  c.i.p.w.c.BlockingController.helloBlocking - BlockingController, the thread is http-nio-8091-exec-2
31-08-2020 13:38:36.189 [http-nio-8091-exec-5] INFO  c.i.p.w.c.BlockingController.helloBlocking - BlockingController, the thread is http-nio-8091-exec-5
31-08-2020 13:38:36.189 [http-nio-8091-exec-20] INFO  c.i.p.w.c.BlockingController.helloBlocking - BlockingController, the thread is http-nio-8091-exec-20
31-08-2020 13:38:36.189 [http-nio-8091-exec-17] INFO  c.i.p.w.c.BlockingController.helloBlocking - BlockingController, the thread is http-nio-8091-exec-17
31-08-2020 13:38:36.189 [http-nio-8091-exec-14] INFO  c.i.p.w.c.BlockingController.helloBlocking - BlockingController, the thread is http-nio-8091-exec-14
31-08-2020 13:38:36.190 [http-nio-8091-exec-8] INFO  c.i.p.w.c.BlockingController.helloBlocking - BlockingController, the thread is http-nio-8091-exec-8
31-08-2020 13:38:36.194 [http-nio-8091-exec-9] INFO  c.i.p.w.c.BlockingController.helloBlocking - BlockingController, the thread is http-nio-8091-exec-9
31-08-2020 13:38:36.190 [http-nio-8091-exec-16] INFO  c.i.p.w.c.BlockingController.helloBlocking - BlockingController, the thread is http-nio-8091-exec-16
31-08-2020 13:38:36.190 [http-nio-8091-exec-7] INFO  c.i.p.w.c.BlockingController.helloBlocking - BlockingController, the thread is http-nio-8091-exec-7
31-08-2020 13:38:36.194 [http-nio-8091-exec-12] INFO  c.i.p.w.c.BlockingController.helloBlocking - BlockingController, the thread is http-nio-8091-exec-12
31-08-2020 13:38:36.194 [http-nio-8091-exec-10] INFO  c.i.p.w.c.BlockingController.helloBlocking - BlockingController, the thread is http-nio-8091-exec-10
31-08-2020 13:38:36.195 [http-nio-8091-exec-4] INFO  c.i.p.w.c.BlockingController.helloBlocking - BlockingController, the thread is http-nio-8091-exec-4
31-08-2020 13:38:36.199 [http-nio-8091-exec-6] INFO  c.i.p.w.c.BlockingController.helloBlocking - BlockingController, the thread is http-nio-8091-exec-6
31-08-2020 13:38:36.189 [http-nio-8091-exec-15] INFO  c.i.p.w.c.BlockingController.helloBlocking - BlockingController, the thread is http-nio-8091-exec-15
31-08-2020 13:38:36.190 [http-nio-8091-exec-13] INFO  c.i.p.w.c.BlockingController.helloBlocking - BlockingController, the thread is http-nio-8091-exec-13
31-08-2020 13:38:36.194 [http-nio-8091-exec-18] INFO  c.i.p.w.c.BlockingController.helloBlocking - BlockingController, the thread is http-nio-8091-exec-18
```
and
```
31-08-2020 13:40:14.284 [reactor-http-epoll-1] INFO  c.i.p.w.c.NonBlockingController.helloNonBlocking - NonBlockingController, the thread is reactor-http-epoll-1
31-08-2020 13:40:14.284 [reactor-http-epoll-7] INFO  c.i.p.w.c.NonBlockingController.helloNonBlocking - NonBlockingController, the thread is reactor-http-epoll-7
31-08-2020 13:40:14.284 [reactor-http-epoll-2] INFO  c.i.p.w.c.NonBlockingController.helloNonBlocking - NonBlockingController, the thread is reactor-http-epoll-2
31-08-2020 13:40:14.286 [reactor-http-epoll-8] INFO  c.i.p.w.c.NonBlockingController.helloNonBlocking - NonBlockingController, the thread is reactor-http-epoll-8
31-08-2020 13:40:14.284 [reactor-http-epoll-3] INFO  c.i.p.w.c.NonBlockingController.helloNonBlocking - NonBlockingController, the thread is reactor-http-epoll-3
31-08-2020 13:40:14.286 [reactor-http-epoll-4] INFO  c.i.p.w.c.NonBlockingController.helloNonBlocking - NonBlockingController, the thread is reactor-http-epoll-4
31-08-2020 13:40:14.284 [reactor-http-epoll-6] INFO  c.i.p.w.c.NonBlockingController.helloNonBlocking - NonBlockingController, the thread is reactor-http-epoll-6
31-08-2020 13:40:14.284 [reactor-http-epoll-5] INFO  c.i.p.w.c.NonBlockingController.helloNonBlocking - NonBlockingController, the thread is reactor-http-epoll-5
31-08-2020 13:40:14.355 [reactor-http-epoll-1] INFO  c.i.p.w.c.NonBlockingController.helloNonBlocking - NonBlockingController, the thread is reactor-http-epoll-1
31-08-2020 13:40:14.355 [reactor-http-epoll-2] INFO  c.i.p.w.c.NonBlockingController.helloNonBlocking - NonBlockingController, the thread is reactor-http-epoll-2
31-08-2020 13:40:14.355 [reactor-http-epoll-4] INFO  c.i.p.w.c.NonBlockingController.helloNonBlocking - NonBlockingController, the thread is reactor-http-epoll-4
31-08-2020 13:40:14.355 [reactor-http-epoll-5] INFO  c.i.p.w.c.NonBlockingController.helloNonBlocking - NonBlockingController, the thread is reactor-http-epoll-5
31-08-2020 13:40:14.357 [reactor-http-epoll-3] INFO  c.i.p.w.c.NonBlockingController.helloNonBlocking - NonBlockingController, the thread is reactor-http-epoll-3
31-08-2020 13:40:14.358 [reactor-http-epoll-1] INFO  c.i.p.w.c.NonBlockingController.helloNonBlocking - NonBlockingController, the thread is reactor-http-epoll-1
31-08-2020 13:40:14.361 [reactor-http-epoll-6] INFO  c.i.p.w.c.NonBlockingController.helloNonBlocking - NonBlockingController, the thread is reactor-http-epoll-6
31-08-2020 13:40:14.361 [reactor-http-epoll-3] INFO  c.i.p.w.c.NonBlockingController.helloNonBlocking - NonBlockingController, the thread is reactor-http-epoll-3
31-08-2020 13:40:14.362 [reactor-http-epoll-5] INFO  c.i.p.w.c.NonBlockingController.helloNonBlocking - NonBlockingController, the thread is reactor-http-epoll-5
31-08-2020 13:40:14.363 [reactor-http-epoll-7] INFO  c.i.p.w.c.NonBlockingController.helloNonBlocking - NonBlockingController, the thread is reactor-http-epoll-7
31-08-2020 13:40:14.381 [reactor-http-epoll-8] INFO  c.i.p.w.c.NonBlockingController.helloNonBlocking - NonBlockingController, the thread is reactor-http-epoll-8
31-08-2020 13:40:14.384 [reactor-http-epoll-8] INFO  c.i.p.w.c.NonBlockingController.helloNonBlocking - NonBlockingController, the thread is reactor-http-epoll-8
```

After each blocking and non-blocking application starts, the corresponding service is called several times in parallel.
It is done to show the difference between the thread model of Spring MVC and Spring Webflux:
In the Spring MVC case, every call consumes separate thread, while Spring Webflux uses an only limited pool of 
`http-epoll` threads to handle requests.

## Conclusions

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

## Performance
Please read [the article](https://medium.com/@filia.aleks/microservice-performance-battle-spring-mvc-vs-webflux-80d39fd81bf0) 
describing a benchmark with comparison of
* Blocking approach with increasing the thread pool size
* CompletableFuture with Servlet (Non-Blocking)
* Spring reactive with WebFlux
