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



SELECT * FROM `treasure_adjust` where user_id = 3829399 and target_id = 5629660

SELECT * FROM `growing_log` where user_id = 3829399 order by create_time desc

SELECT * FROM `treasure_adjust` where user_id = 3829399 and target_id = 5629660 and session_id = 1570753762601519

SELECT user_id,target_id,gift_id,gift_total_coins,create_time FROM `treasure_adjust` where user_id = 3829399 and target_id = 5629660 and session_id = 1570753762601519



select gift_item.*, t1.gift_category_id, t1.weight_in_category from gift_category_mapping as t1 join gift_item where t1.gift_id = gift_item.id and gift_item.is_active = true and now() >= active_time_start and (now() <= active_time_end or active_time_end is null) and gift_item.`gift_id` in('PerfumeElite','like-gif','horse') order by t1.weight_in_category desc
