Springboot: Spring Boot is a Spring framework module which provides RAD (Rapid Application Development) feature to the Spring framework.

Advantages: Create stand-alone Spring applications that can be started using java -jar. Embed Tomcat, Jetty or Undertow directly. You don't need to deploy WAR files. It provides opinionated 'starter' POMs to simplify your Maven configuration. It automatically configure Spring whenever possible. It provides production-ready features such as metrics, health checks and externalized configuration. Absolutely no code generation and no requirement for XML configuration.

Prerequisites of springboot: Java 1.8 Gradle 2.3+ or Maven 3.0+ Spring Framework 5.0.0.BUILD-SNAPSHOT

Springboot modules: CLI: Starters: collection of all the relevant transitive dependencies that are needed to start a particular functionality. For example, If you want to create a Spring WebMVC application then in a traditional setup, you would have included all required dependencies yourself. It leaves the chances of version conflict which ultimately result in more runtime exceptions. With Spring boot, to create MVC application all you need to import is spring-boot-starter-web dependency.

pom.xml
<!-- Parent pom is mandatory to control versions of child dependencies -->
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.1.6.RELEASE</version>
    <relativePath />
</parent>
 
<!-- Spring web brings all required dependencies to build web application. -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
you do not need to provide version information into child dependencies. All versions are resolved in relation to version of parent starter.

Dependencies brought in by webmvc starter template
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter</artifactId> or spring-boot-starter-json or spring-boot-starter-tomcat or 
        hibernate-validator or spring-web or spring-webmvc
    </dependency>
</dependencies>
AutoConfigure: @EnableAutoConfiguration - Spring boot auto configuration scans the classpath, finds the libraries in the classpath and then attempt to guess the best configuration for them, and finally configure all such beans. For example, look at auto-configuration for Spring AOP. It does the followings- Scan classpath to see if EnableAspectJAutoProxy, Aspect, Advice and AnnotatedElement classes are present. If classes are not present, no autoconfiguration will be made for Spring AOP. If classes are found then AOP is configured with Java config annotation @EnableAspectJAutoProxy. It checks for property spring.aop which value can be true or false. Based on the value of property, proxyTargetClass attribute is set.

@Configuration
@ConditionalOnClass({ EnableAspectJAutoProxy.class, Aspect.class, Advice.class,
        AnnotatedElement.class })
@ConditionalOnProperty(prefix = "spring.aop", name = "auto", havingValue = "true", matchIfMissing = true)
public class AopAutoConfiguration 
{
    @Configuration
    @EnableAspectJAutoProxy(proxyTargetClass = false)
    @ConditionalOnProperty(prefix = "spring.aop", name = "proxy-target-class", havingValue = "false", matchIfMissing = false)
    public static class JdkDynamicAutoProxyConfiguration {
    }
 
    @Configuration
    @EnableAspectJAutoProxy(proxyTargetClass = true)
    @ConditionalOnProperty(prefix = "spring.aop", name = "proxy-target-class", havingValue = "true", matchIfMissing = true)
    public static class CglibAutoProxyConfiguration {
    }
}
Actuator: The spring-boot-actuator module provides all of Spring Boot’s production-ready features Actuators can generate a large amount of motion from a small change.

<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
</dependencies>
Actuator endpoints let you monitor and interact with your application. it maintains the application context and provides few following features, caching, auditEvents, health, httptrace, liqibase Enabling Endpoints By default, all endpoints except for shutdown are enabled management.endpoint.shutdown.enabled=true Securing HTTP Endpoints: using RequestMatcher

@Configuration(proxyBeanMethods = false)
public class ActuatorSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatcher(EndpointRequest.toAnyEndpoint()).authorizeRequests((requests) ->
                requests.anyRequest().hasRole("ENDPOINT_ADMIN"));
        http.httpBasic();
    }
}
CORS support: management.endpoints.web.cors.allowed-origins=https://example.com management.endpoints.web.cors.allowed-methods=GET,POST

Custom End Points:

If you add a @Bean annotated with @Endpoint, any methods annotated with @ReadOperation, @WriteOperation, or @DeleteOperation are automatically exposed over JMX and, in a web application, over HTTP as well. Endpoints can be exposed over HTTP using Jersey, Spring MVC, or Spring WebFlux. If both Jersey and Spring MVC are available, Spring MVC will be used.

if you need access to web-framework-specific functionality, you can implement Servlet or Spring @Controller and @RestController Consumes For a @WriteOperation (HTTP POST) that uses the request body, Produces The produces clause of the predicate can be determined by the produces attribute of the @DeleteOperation, @ReadOperation, and @WriteOperation annotations.
Auditing:
AuditEventRepository,
springboot by default provides InMemoryAuditEventRepository. useful only for development environments.

Default Caching:
```application.properties
management.endpoint.beans.cache.time-to-live=10s```

CloundFoundry:  The /cloudfoundryapplication path is not directly accessible to regular users. In order to use the endpoint, 
a valid UAA token must be passed with the request.

Embedded Server: Spring boot applications always include tomcat as embedded server dependency. 
Each individual endpoint can be enabled or disabled. by default, the health endpoint is mapped to /actuator/health.
For example, below configuration exclude tomcat and include jetty as embedded server. pom.xml org.springframework.boot spring-boot-starter-web org.springframework.boot spring-boot-starter-tomcat

org.springframework.boot spring-boot-starter-jetty ``` Spring Boot Features Web Development, SpringApplication, Application events and listeners, Admin features, Externalized Configuration, Properties Files YAML Support, Type-safe Configuration, Logging, Security