# srpc

SRPC is a kind of RPC tools , The full name is Simple Remote Procedure Call. SRPC’ target is simple and easy.

Main technology
Jdk 1.8，Spring boot 2.x，Netty 4.x

Other
Maven，GitHub，IDEA

Model
Main srpc
Subs org.jiage.srpc.api,org.jiage.srpc.server


Reference
https://netty.io/wiki/user-guide-for-4.x.html
https://github.com/starjiang/easycall

1. Server
Service registration
1) Interface, a unique identifier for service discovery.
2) Interface implementation class, the server implements the implementation class object of the interface, and the server automatically loads it into the local cache of the server after starting.
3) Service group name
4) Service port number
2. Client
Service discovery
1) Service invocation, configuration of invoked services, unique identification of interface services, service group
2) Automatically load services to local cache after service startup

