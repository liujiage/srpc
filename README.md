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




insert into temp_badge(uid) values(6448807);
insert into temp_badge(uid) values(1788720);
insert into temp_badge(uid) values(2702069);
insert into temp_badge(uid) values(3069441);
insert into temp_badge(uid) values(4316323);
insert into temp_badge(uid) values(5670685);
insert into temp_badge(uid) values(449138);
insert into temp_badge(uid) values(900371);
insert into temp_badge(uid) values(3672855);
insert into temp_badge(uid) values(3373173);
insert into temp_badge(uid) values(6219639);
insert into temp_badge(uid) values(5541292);
insert into temp_badge(uid) values(676599);
insert into temp_badge(uid) values(375274);
insert into temp_badge(uid) values(2182692);
insert into temp_badge(uid) values(2809039);
insert into temp_badge(uid) values(6471220);
insert into temp_badge(uid) values(5049727);
insert into temp_badge(uid) values(6075256);
insert into temp_badge(uid) values(4212125);
insert into temp_badge(uid) values(6646328);
insert into temp_badge(uid) values(4857230);
insert into temp_badge(uid) values(7055298);
insert into temp_badge(uid) values(294169);
insert into temp_badge(uid) values(6529443);
insert into temp_badge(uid) values(586554);
insert into temp_badge(uid) values(5939345);
insert into temp_badge(uid) values(3630311);
insert into temp_badge(uid) values(6804698);
insert into temp_badge(uid) values(5499943);
insert into temp_badge(uid) values(6376483);
insert into temp_badge(uid) values(6519122);
insert into temp_badge(uid) values(6923325);
insert into temp_badge(uid) values(5478774);
insert into temp_badge(uid) values(6410501);
insert into temp_badge(uid) values(479607);
insert into temp_badge(uid) values(2180941);
insert into temp_badge(uid) values(4995392);
insert into temp_badge(uid) values(6970231);
insert into temp_badge(uid) values(5767684);
insert into temp_badge(uid) values(3328708);
insert into temp_badge(uid) values(3418078);
insert into temp_badge(uid) values(4762176);
insert into temp_badge(uid) values(261044);
insert into temp_badge(uid) values(6538564);
insert into temp_badge(uid) values(299485);
insert into temp_badge(uid) values(3341607);
insert into temp_badge(uid) values(6904349);
insert into temp_badge(uid) values(6615939);
insert into temp_badge(uid) values(7053809);
insert into temp_badge(uid) values(1052875);
insert into temp_badge(uid) values(316727);
insert into temp_badge(uid) values(342367);
insert into temp_badge(uid) values(6535199);
insert into temp_badge(uid) values(1534779);
insert into temp_badge(uid) values(5143600);
insert into temp_badge(uid) values(3993258);
insert into temp_badge(uid) values(7005719);
insert into temp_badge(uid) values(6560573);
insert into temp_badge(uid) values(918981);
insert into temp_badge(uid) values(5654459);
insert into temp_badge(uid) values(2237660);
insert into temp_badge(uid) values(6908429);
insert into temp_badge(uid) values(5681193);
insert into temp_badge(uid) values(5424912);
insert into temp_badge(uid) values(1514310);
insert into temp_badge(uid) values(4247238);
insert into temp_badge(uid) values(6547492);
insert into temp_badge(uid) values(6994792);
insert into temp_badge(uid) values(4353364);
insert into temp_badge(uid) values(4059599);
insert into temp_badge(uid) values(2823620);
insert into temp_badge(uid) values(6349474);
insert into temp_badge(uid) values(6501608);
insert into temp_badge(uid) values(6188505);
insert into temp_badge(uid) values(6449790);
insert into temp_badge(uid) values(6495825);
insert into temp_badge(uid) values(4777477);
insert into temp_badge(uid) values(5822812);
insert into temp_badge(uid) values(6063584);
insert into temp_badge(uid) values(7070288);
insert into temp_badge(uid) values(317587);
insert into temp_badge(uid) values(1345775);
insert into temp_badge(uid) values(5189040);
insert into temp_badge(uid) values(7082380);
insert into temp_badge(uid) values(6573943);
insert into temp_badge(uid) values(2289258);
insert into temp_badge(uid) values(6801614);
insert into temp_badge(uid) values(4764710);
insert into temp_badge(uid) values(678185);
insert into temp_badge(uid) values(3126205);
insert into temp_badge(uid) values(5633230);
insert into temp_badge(uid) values(6824543);
insert into temp_badge(uid) values(1695931);
insert into temp_badge(uid) values(6584597);
insert into temp_badge(uid) values(7034141);
insert into temp_badge(uid) values(5636204);
insert into temp_badge(uid) values(3834237);
insert into temp_badge(uid) values(7057831);
insert into temp_badge(uid) values(2991399);
insert into temp_badge(uid) values(6417507);
insert into temp_badge(uid) values(3759688);
insert into temp_badge(uid) values(3152742);
insert into temp_badge(uid) values(6582712);
insert into temp_badge(uid) values(312401);
insert into temp_badge(uid) values(5627915);
insert into temp_badge(uid) values(5721024);
insert into temp_badge(uid) values(5917133);
insert into temp_badge(uid) values(6591239);
insert into temp_badge(uid) values(6558002);
insert into temp_badge(uid) values(3678845);
insert into temp_badge(uid) values(6516329);
insert into temp_badge(uid) values(6544415);
insert into temp_badge(uid) values(6452493);
insert into temp_badge(uid) values(1577159);
insert into temp_badge(uid) values(6789710);
insert into temp_badge(uid) values(1175444);
insert into temp_badge(uid) values(7004805);
insert into temp_badge(uid) values(3711951);
insert into temp_badge(uid) values(590806);
insert into temp_badge(uid) values(3471610);
insert into temp_badge(uid) values(6942682);
insert into temp_badge(uid) values(5419287);
insert into temp_badge(uid) values(6999977);
insert into temp_badge(uid) values(1848750);
insert into temp_badge(uid) values(3763728);
insert into temp_badge(uid) values(3490317);
insert into temp_badge(uid) values(3546217);
insert into temp_badge(uid) values(341364);
insert into temp_badge(uid) values(6855500);
insert into temp_badge(uid) values(645289);
insert into temp_badge(uid) values(3978757);
insert into temp_badge(uid) values(6410901);
insert into temp_badge(uid) values(6530014);
insert into temp_badge(uid) values(6754951);
insert into temp_badge(uid) values(6942667);
insert into temp_badge(uid) values(4953593);
insert into temp_badge(uid) values(6993708);
insert into temp_badge(uid) values(6958929);
insert into temp_badge(uid) values(7038779);
insert into temp_badge(uid) values(764036);
insert into temp_badge(uid) values(6937237);
insert into temp_badge(uid) values(2353099);
insert into temp_badge(uid) values(6520292);
insert into temp_badge(uid) values(6917477);
insert into temp_badge(uid) values(6593915);
insert into temp_badge(uid) values(3758634);
insert into temp_badge(uid) values(3961778);
insert into temp_badge(uid) values(5065015);
insert into temp_badge(uid) values(6926289);
insert into temp_badge(uid) values(6638688);
insert into temp_badge(uid) values(6963825);
insert into temp_badge(uid) values(7029443);
insert into temp_badge(uid) values(3570889);
insert into temp_badge(uid) values(7011759);
insert into temp_badge(uid) values(5121369);
insert into temp_badge(uid) values(6919522);
insert into temp_badge(uid) values(1239399);
insert into temp_badge(uid) values(686062);
insert into temp_badge(uid) values(1983876);
insert into temp_badge(uid) values(5697513);
insert into temp_badge(uid) values(3696536);
insert into temp_badge(uid) values(7025991);
insert into temp_badge(uid) values(6777769);
insert into temp_badge(uid) values(7058369);
insert into temp_badge(uid) values(5934608);
insert into temp_badge(uid) values(5119508);
insert into temp_badge(uid) values(4307106);
insert into temp_badge(uid) values(2631880);
insert into temp_badge(uid) values(6350566);
insert into temp_badge(uid) values(5777703);
