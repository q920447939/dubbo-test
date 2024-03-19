### NOTE

this project dependency `Nacos(2.3.1)`,

The following lists the required configurations

#### step1:

​	in `nacos` admin console , add `namespace` is `dev`  ,And specify the namespace id as `061a16bb-74f0-4687-9cbb-0865a86b9d39`

​	then add two configurations to the dev environment

​	`host.yml` configuration is as follow

```yaml
host:
    hostname: 127.0.0.1
    nacos:
        hostname: ${host.hostname}
        port: 8848     
```

​	`spring-dubbo.yml` configuration is as follow

 ```yaml
dubbo:
  application:
    name: ${spring.application.name}-dubbo
    qos-port: 30002
    serialize-check-status: DISABLE
    auto-trust-serialize-class: "true"
    trust-serialize-class-level: "3"
  protocol:
    name: dubbo
    port: -1
  registry:
    address: nacos://${host.nacos.hostname}:${host.nacos.port}
    group: dubbo
    #注册模式为实例级别
    register-mode: instance
    #这里配置的是自定义的配置（文档中并没有指明有哪些配置），其中namespace就在这里配置
    parameters:
      namespace: ${spring.cloud.nacos.config.namespace}
  consumer:
    check: false
    #filter: consumerStartFilter,consumerEndFilter
    config-center:
      timeout: 10000
    #指定服务提供者的namespace （配置文档中有说明）
    provider-namespace: ${spring.cloud.nacos.config.namespace}  
  config-center:
  #指定配置中心的namespace（配置文档中有说明）
    namespace: ${spring.cloud.nacos.config.namespace}
    address: nacos://${host.nacos.hostname}:${host.nacos.port}
    group: dubbo

project:
  name: ${spring.application.name}-dubbo
 ```



### start params(at IDEA is VM options)：

​    dubbo-consumer: `-Dspring.profiles.active=dev -Dproject.name=dubbo-consumer-dubbo -Dcom.alibaba.nacos.shaded.io.grpc.netty.shaded.io.netty.tryReflectionSetAccessible=true -Dio.netty.tryReflectionSetAccessible=true --add-opens java.base/jdk.internal.misc=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.math=ALL-UNNAMED --add-opens java.base/java.nio=ALL-UNNAMED --add-opens java.base/sun.reflect.annotation=ALL-UNNAMED`

   dubbo-provider: `-Dspring.profiles.active=dev  -Dproject.name=dubbo-provider-dubbo -Dcom.alibaba.nacos.shaded.io.grpc.netty.shaded.io.netty.tryReflectionSetAccessible=true -Dio.netty.tryReflectionSetAccessible=true --add-opens java.base/jdk.internal.misc=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.math=ALL-UNNAMED --add-opens java.base/java.nio=ALL-UNNAMED --add-opens java.base/sun.reflect.annotation=ALL-UNNAMED`



