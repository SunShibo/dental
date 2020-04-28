/*
Navicat MySQL Data Transfer

Source Server         : wy
Source Server Version : 50727
Source Host           : 47.94.143.11:3306
Source Database       : brace

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2020-04-28 15:10:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文章',
  `type` varchar(255) DEFAULT NULL COMMENT '分类 文章/案例',
  `img` varchar(255) DEFAULT NULL COMMENT '图片路径',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` text COMMENT '内容',
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `name` varchar(255) DEFAULT NULL COMMENT '作者',
  `digest` varchar(2000) DEFAULT NULL COMMENT '摘要',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', 'article', 'https://knorr.oss-cn-beijing.aliyuncs.com/static/c-img/e-1.png', '荒木画展0', 'content: \"<p>编者按：本文来自36氪「<a href=\"https://auto-time.36kr.com/p/659198250467329\" target=\"_blank\">未来汽车日报</a>」（微信公众号ID：auto-time），作者：李欢欢。</p><p>&nbsp; &nbsp; &nbsp; &nbsp; <img style=\"max-width:100%\" alt=\"地方政府救市哪家强？广州补贴上万元，广深杭新增指标超5万\" src=\"https://img.36krcdn.com/20200410/v2_cc370813b05a4e5286ae578e1df4632b_img_000\" data-img-size-val=\"949,624\"> </p> ↵<p    class=\"img-desc\">&nbsp; &nbsp;&nbsp; 封面来源：unsplash</p> ↵<p>作者丨李欢欢</p> ↵<p>编辑丨吴岩 <br></p> ↵<p>产销数据尚未止跌，但中国车市正在复苏。 <br></p> ↵<p>4月9日，全国乘用车市场信息联席会（以下简称“乘联会”）发布最新一期乘用车产销数据，3月狭义乘用车市场零售104.5万辆，同比下降40.4%，降幅相较上月提升38个百分点，环比增长317.5%。中国汽车流通协会发布报告称，汽车4S店已基本复工，客流恢复率达到63.5%，销售效率61.4%。 <br></p> ↵<p>&nbsp; &nbsp; &nbsp; &nbsp; <img style=\"max-width:100%\" alt=\"地方政府救市哪家强？广州补贴上万元，广深杭新增指标超5万\" src=\"https://img.36krcdn.com/20200410/v2_0575c4ed5e5249078095d5db742a479b_img_000\" data-img-size-val=\"1357,770\"> </p> ↵<p    class=\"img-desc\">&nbsp; &nbsp;&nbsp; 来源：乘联会 <br></p> ↵<p>中国汽车业逐步恢复正轨，部分得益于政策推动。 <br></p> ↵<p>3月31日，国务院常务会议决定将新能源汽车购置补贴和免征购置税政策延长2年；中央财政以奖代补，支持京津冀等重点地区淘汰国三及以下排放标准柴油货车；从今年5月1日至2023年底，二手车经销企业销售旧车减按销售额0.5%征收增值税。 <br></p> ↵<p>地方政府也已先后行动起来。截至目前，北京、广州、佛山、杭州、长沙等十数个城市出手救市，出台政策促进汽车消费。目前来看，各地刺激消费的方式大致相同，以购车专项奖励、发放购车及报废旧车补贴为主。此外，备受诟病的购车摇号政策也悄然出现松动，广州、深圳、杭州等地已宣布增加数额不等的购车指标。</p> ↵<h3  >广州出手最大方</h3> ↵<p>作为中国首个十万亿GDP大省，广东已经连续31年蝉联全国经济第一。2019年，广东省以10.7万亿的GDP总量超过了全球90%以上的国家。拥有强大的经济实力做后盾，广东省成为这一轮政策救市的先锋。 <br></p> ↵<p>2月3日，佛山成为第一个出手救市的城市，鼓励消费者购买“国六”标准排量汽车，给予每辆车2000-5000元不等的补贴。广州、珠海、长沙、杭州等地相继跟进。其中，广州补贴力度最大、范围最广，并着重鼓励消费者购买新能源汽车。 <br></p> ↵<p>3月5日，广州市政府宣布在使用环节对个人消费者购买新能源汽车给予1万元补贴，置换或报废二手车的消费者，如购买国六标准新车给予补助3000元。4月3日，广州市商务局针对上述两类消费者再追加4.5亿元消费补贴。 <br></p> ↵<p>佛山、长春补贴范围也涵盖了新车购买和旧车置换，金额分别为2000-3000元、4000-5000元。这两个城市还鼓励集体采购，佛山规定如同一消费者一次性购买的大、中、重型客运、载货汽车（车辆单价不少于50万元）达到5台及以上，每辆车补助可达5000元。长春则规定集体采购5台及以上（单价超过20万元）的新车，每车补助不超过6000元。 <br></p> ↵<p>宁波推出的补贴规则更加宽松，消费者购买宁波本地生产、销售的乘用车并在本地上牌的，给予每辆车一次性让利5000元，无需旧车发票或报废证明。此外，重庆、南昌、湘潭、长沙、山西等地推出的补贴标准为500-6000元不等。 <br></p> ↵<p>另有一些城市政策侧重点有所不同。四川面向全国农村消费者推出补贴政策，买车补贴1000元起。广州的政策除了消费者，还惠及车企，对广州市整车制造企业补贴消费者竞价费用达到每辆车1万元，广州市财政相应给予广州整车制造企业每辆车5000元奖励。此外，广州还推动汽车注册登记和车辆购置税信息网上审核，实现车辆登记上牌 “零跑动”。 <br></p> ↵<p>崔东树接受未来汽车日报（ID：auto-time）采访时表示，目前各地政府补贴金额大致为2000-5000元。</p> ↵<h3  >限购政策悄然松动</h3> ↵<p>2019年9月12日，贵阳市政府正式宣布废除汽车限购措施，并取消“购车摇号”，成为全国首个取消汽车限购的城市。 <br></p> ↵<p>车市寒冬遭遇疫情雪上加霜，业内专家纷纷呼吁松绑汽车限购。 <br></p> ↵<p>中汽协副秘书长叶盛基建议相关部门出台政策刺激汽车消费，提议“限购地区适当增加汽车号牌配额”。崔东树表示，增加购车指标可以“有针对性拉动首购群体消费”。中国汽车流通协会副秘书长郎学红则认为，这么做“能够立竿见影地促进汽车消费”。 <br></p> ↵<p>因为，被限购政策束缚的是一个数字庞大的群体。仅以北京为例，据北京市小客车指标调控管理办公室发布的数据，截至2020年2月8日24时，北京市普通小客车指标申请个人共有3350538个有效编码，配置个人普通小客车指标6417个。也就是说，目前北京有超过335万人有购车意愿，但中签率仅1:522。 <br></p> ↵<p>3月24日，商务部发文宣布北京将新增10万个新能源购车指标，一经发布便引发热议，被解读为坚若磐石的北京购车摇号政策松动的信号。随后，这项政策被紧急撤回，并官方致歉称“未经研究论证”。 <br></p> ↵<p>北京新增购车指标事件只是一次“乌龙”，却似乎为其他限购城市吹响了松绑的号角。 <br></p> ↵<p>4月9日，深圳市交通运输局宣布，面向个人配置1万个混合动力小汽车指标，只能用于新购车辆上牌。4月8日，广州市中小客车调控部门通知，4月广州将新增中小客车指标共17089个，总配置指标数较3月增加近70%。更早些时候，杭州市小客车总量调控管理办公室宣布2020年将一次性增加2万个小客车指标。 <br></p> ↵<p>此外，上海等地已在酝酿释放更多购车指标，促进新车销售。</p> ↵<h3  >亟待更多细则出台</h3> ↵<p>与广州、长沙等地以补贴促进新车消费不同，北京把救市的目光聚焦在存量市场。 <br></p> ↵<p>3月30日，北京宣布今年4月1日-12月31日期间，提前报废或转出的国三车型车主可享受2000元-2.2万元不等的补贴。这项政策的意义，在于促进高排放老旧机动车淘汰更新，优化机动车存量结构。相比刺激首购，北京着力促进换购消费，在存量市场寻求车市的突破点。 <br></p> ↵<p>麦肯锡的一份报告指出，2019年，购车群体中增换购比例比2017年显著提升，换购比重由10%增至23%，增购人群增至7%。这意味着，存量市场正在崛起。 <br></p> ↵<p>据未来汽车日报（ID：auto-time）不完全统计，目前已有至少14个城市出台政策刺激汽车消费。但中国汽车工程学会名誉理事长付于武认为，目前出台的政策还不够，国家和地方政府还应该持续推出更有力的政策。 <br></p> ↵<p>乘联会秘书长崔东树接受未来汽车日报（ID：auto-time）采访时表示，政策密集发布，确实使汽车市场产生波动。不过，部分地区虽然出台了促进汽车消费政策，但执行细节不清晰，消费者仍在观望国家层面的促消费政策。因此，“各地政策落地效果并不突出，月末零售量提升有所放缓”。 <br></p> ↵<p>崔东树表示，补贴力度应该能产生一定拉动消费的效果，但是“各地并没有出台补贴细则，加之各地财政状况吃紧，消费者想真正拿到这笔补贴很难，因此补贴效果大打折扣”。 <br></p> ↵<p>4月2日，商务部消费促进司副司长王斌表示，要促进稳定新车销售，推动有关地方放宽或取消限购措施。4月7日，工信部公布修改版《新能源汽车生产企业及产品准入管理规定》并公开征求意见，进一步放宽新能源汽车生产企业及产品准入门槛。 <br></p> ↵<p>在国家层面政策的带动下，未来或将有更多地方政府推出救市政策。 <br></p> ↵<p>4月8日零时起，武汉正式解封，被疫情阴霾笼罩许久的汽车业逐步回到正轨。在政策推动下，再加上车企采取种种自救措施，崔东树认为，“3月车市触底反弹，4月车市会更好”。</p> ↵<p><img style=\"max-width:100%\" alt=\"地方政府救市哪家强？广州补贴上万元，广深杭新增指标超5万\" src=\"https://img.36krcdn.com/20200410/v2_4494b0ad1e0b4f4d999c9a903ba90c8b_img_gif\" data-img-size-val=\"900,500\"></p> ↵\"\r\ncontent: \"<p>编者按：本文来自36氪「<a href=\"https://auto-time.36kr.com/p/659198250467329\" target=\"_blank\">未来汽车日报</a>」（微信公众号ID：auto-time），作者：李欢欢。</p><p>&nbsp; &nbsp; &nbsp; &nbsp; <img style=\"max-width:100%\" alt=\"地方政府救市哪家强？广州补贴上万元，广深杭新增指标超5万\" src=\"https://img.36krcdn.com/20200410/v2_cc370813b05a4e5286ae578e1df4632b_img_000\" data-img-size-val=\"949,624\"> </p> ↵<p    class=\"img-desc\">&nbsp; &nbsp;&nbsp; 封面来源：unsplash</p> ↵<p>作者丨李欢欢</p> ↵<p>编辑丨吴岩 <br></p> ↵<p>产销数据尚未止跌，但中国车市正在复苏。 <br></p> ↵<p>4月9日，全国乘用车市场信息联席会（以下简称“乘联会”）发布最新一期乘用车产销数据，3月狭义乘用车市场零售104.5万辆，同比下降40.4%，降幅相较上月提升38个百分点，环比增长317.5%。中国汽车流通协会发布报告称，汽车4S店已基本复工，客流恢复率达到63.5%，销售效率61.4%。 <br></p> ↵<p>&nbsp; &nbsp; &nbsp; &nbsp; <img style=\"max-width:100%\" alt=\"地方政府救市哪家强？广州补贴上万元，广深杭新增指标超5万\" src=\"https://img.36krcdn.com/20200410/v2_0575c4ed5e5249078095d5db742a479b_img_000\" data-img-size-val=\"1357,770\"> </p> ↵<p    class=\"img-desc\">&nbsp; &nbsp;&nbsp; 来源：乘联会 <br></p> ↵<p>中国汽车业逐步恢复正轨，部分得益于政策推动。 <br></p> ↵<p>3月31日，国务院常务会议决定将新能源汽车购置补贴和免征购置税政策延长2年；中央财政以奖代补，支持京津冀等重点地区淘汰国三及以下排放标准柴油货车；从今年5月1日至2023年底，二手车经销企业销售旧车减按销售额0.5%征收增值税。 <br></p> ↵<p>地方政府也已先后行动起来。截至目前，北京、广州、佛山、杭州、长沙等十数个城市出手救市，出台政策促进汽车消费。目前来看，各地刺激消费的方式大致相同，以购车专项奖励、发放购车及报废旧车补贴为主。此外，备受诟病的购车摇号政策也悄然出现松动，广州、深圳、杭州等地已宣布增加数额不等的购车指标。</p> ↵<h3  >广州出手最大方</h3> ↵<p>作为中国首个十万亿GDP大省，广东已经连续31年蝉联全国经济第一。2019年，广东省以10.7万亿的GDP总量超过了全球90%以上的国家。拥有强大的经济实力做后盾，广东省成为这一轮政策救市的先锋。 <br></p> ↵<p>2月3日，佛山成为第一个出手救市的城市，鼓励消费者购买“国六”标准排量汽车，给予每辆车2000-5000元不等的补贴。广州、珠海、长沙、杭州等地相继跟进。其中，广州补贴力度最大、范围最广，并着重鼓励消费者购买新能源汽车。 <br></p> ↵<p>3月5日，广州市政府宣布在使用环节对个人消费者购买新能源汽车给予1万元补贴，置换或报废二手车的消费者，如购买国六标准新车给予补助3000元。4月3日，广州市商务局针对上述两类消费者再追加4.5亿元消费补贴。 <br></p> ↵<p>佛山、长春补贴范围也涵盖了新车购买和旧车置换，金额分别为2000-3000元、4000-5000元。这两个城市还鼓励集体采购，佛山规定如同一消费者一次性购买的大、中、重型客运、载货汽车（车辆单价不少于50万元）达到5台及以上，每辆车补助可达5000元。长春则规定集体采购5台及以上（单价超过20万元）的新车，每车补助不超过6000元。 <br></p> ↵<p>宁波推出的补贴规则更加宽松，消费者购买宁波本地生产、销售的乘用车并在本地上牌的，给予每辆车一次性让利5000元，无需旧车发票或报废证明。此外，重庆、南昌、湘潭、长沙、山西等地推出的补贴标准为500-6000元不等。 <br></p> ↵<p>另有一些城市政策侧重点有所不同。四川面向全国农村消费者推出补贴政策，买车补贴1000元起。广州的政策除了消费者，还惠及车企，对广州市整车制造企业补贴消费者竞价费用达到每辆车1万元，广州市财政相应给予广州整车制造企业每辆车5000元奖励。此外，广州还推动汽车注册登记和车辆购置税信息网上审核，实现车辆登记上牌 “零跑动”。 <br></p> ↵<p>崔东树接受未来汽车日报（ID：auto-time）采访时表示，目前各地政府补贴金额大致为2000-5000元。</p> ↵<h3  >限购政策悄然松动</h3> ↵<p>2019年9月12日，贵阳市政府正式宣布废除汽车限购措施，并取消“购车摇号”，成为全国首个取消汽车限购的城市。 <br></p> ↵<p>车市寒冬遭遇疫情雪上加霜，业内专家纷纷呼吁松绑汽车限购。 <br></p> ↵<p>中汽协副秘书长叶盛基建议相关部门出台政策刺激汽车消费，提议“限购地区适当增加汽车号牌配额”。崔东树表示，增加购车指标可以“有针对性拉动首购群体消费”。中国汽车流通协会副秘书长郎学红则认为，这么做“能够立竿见影地促进汽车消费”。 <br></p> ↵<p>因为，被限购政策束缚的是一个数字庞大的群体。仅以北京为例，据北京市小客车指标调控管理办公室发布的数据，截至2020年2月8日24时，北京市普通小客车指标申请个人共有3350538个有效编码，配置个人普通小客车指标6417个。也就是说，目前北京有超过335万人有购车意愿，但中签率仅1:522。 <br></p> ↵<p>3月24日，商务部发文宣布北京将新增10万个新能源购车指标，一经发布便引发热议，被解读为坚若磐石的北京购车摇号政策松动的信号。随后，这项政策被紧急撤回，并官方致歉称“未经研究论证”。 <br></p> ↵<p>北京新增购车指标事件只是一次“乌龙”，却似乎为其他限购城市吹响了松绑的号角。 <br></p> ↵<p>4月9日，深圳市交通运输局宣布，面向个人配置1万个混合动力小汽车指标，只能用于新购车辆上牌。4月8日，广州市中小客车调控部门通知，4月广州将新增中小客车指标共17089个，总配置指标数较3月增加近70%。更早些时候，杭州市小客车总量调控管理办公室宣布2020年将一次性增加2万个小客车指标。 <br></p> ↵<p>此外，上海等地已在酝酿释放更多购车指标，促进新车销售。</p> ↵<h3  >亟待更多细则出台</h3> ↵<p>与广州、长沙等地以补贴促进新车消费不同，北京把救市的目光聚焦在存量市场。 <br></p> ↵<p>3月30日，北京宣布今年4月1日-12月31日期间，提前报废或转出的国三车型车主可享受2000元-2.2万元不等的补贴。这项政策的意义，在于促进高排放老旧机动车淘汰更新，优化机动车存量结构。相比刺激首购，北京着力促进换购消费，在存量市场寻求车市的突破点。 <br></p> ↵<p>麦肯锡的一份报告指出，2019年，购车群体中增换购比例比2017年显著提升，换购比重由10%增至23%，增购人群增至7%。这意味着，存量市场正在崛起。 <br></p> ↵<p>据未来汽车日报（ID：auto-time）不完全统计，目前已有至少14个城市出台政策刺激汽车消费。但中国汽车工程学会名誉理事长付于武认为，目前出台的政策还不够，国家和地方政府还应该持续推出更有力的政策。 <br></p> ↵<p>乘联会秘书长崔东树接受未来汽车日报（ID：auto-time）采访时表示，政策密集发布，确实使汽车市场产生波动。不过，部分地区虽然出台了促进汽车消费政策，但执行细节不清晰，消费者仍在观望国家层面的促消费政策。因此，“各地政策落地效果并不突出，月末零售量提升有所放缓”。 <br></p> ↵<p>崔东树表示，补贴力度应该能产生一定拉动消费的效果，但是“各地并没有出台补贴细则，加之各地财政状况吃紧，消费者想真正拿到这笔补贴很难，因此补贴效果大打折扣”。 <br></p> ↵<p>4月2日，商务部消费促进司副司长王斌表示，要促进稳定新车销售，推动有关地方放宽或取消限购措施。4月7日，工信部公布修改版《新能源汽车生产企业及产品准入管理规定》并公开征求意见，进一步放宽新能源汽车生产企业及产品准入门槛。 <br></p> ↵<p>在国家层面政策的带动下，未来或将有更多地方政府推出救市政策。 <br></p> ↵<p>4月8日零时起，武汉正式解封，被疫情阴霾笼罩许久的汽车业逐步回到正轨。在政策推动下，再加上车企采取种种自救措施，崔东树认为，“3月车市触底反弹，4月车市会更好”。</p> ↵<p><img style=\"max-width:100%\" alt=\"地方政府救市哪家强？广州补贴上万元，广深杭新增指标超5万\" src=\"https://img.36krcdn.com/20200410/v2_4494b0ad1e0b4f4d999c9a903ba90c8b_img_gif\" data-img-size-val=\"900,500\"></p> ↵\"\r\n', 'yes', '2020-04-22 09:13:40', '吉良吉影', '我是摘要！');
INSERT INTO `article` VALUES ('2', 'article', 'https://img.cdn.aliyun.dcloud.net.cn/uni-app/doc/uni-app-frame-0310.png', '荒木画展1荒木画展1荒木画展1荒木画展1', '<p>编者按：本文来自36氪「<a href=\"https://auto-time.36kr.com/p/659198250467329\" target=\"_blank\">未来汽车日报</a>」（微信公众号ID：auto-time），作者：李欢欢。</p><p>&nbsp; &nbsp; &nbsp; &nbsp; <img style=\"max-width:100%\" alt=\"地方政府救市哪家强？广州补贴上万元，广深杭新增指标超5万\" src=\"https://img.36krcdn.com/20200410/v2_cc370813b05a4e5286ae578e1df4632b_img_000\" data-img-size-val=\"949,624\"> </p> ↵<p    class=\"img-desc\">&nbsp; &nbsp;&nbsp; 封面来源：unsplash</p> ↵<p>作者丨李欢欢</p> ↵<p>编辑丨吴岩 <br></p> ↵<p>产销数据尚未止跌，但中国车市正在复苏。 <br></p> ↵<p>4月9日，全国乘用车市场信息联席会（以下简称“乘联会”）发布最新一期乘用车产销数据，3月狭义乘用车市场零售104.5万辆，同比下降40.4%，降幅相较上月提升38个百分点，环比增长317.5%。中国汽车流通协会发布报告称，汽车4S店已基本复工，客流恢复率达到63.5%，销售效率61.4%。 <br></p> ↵<p>&nbsp; &nbsp; &nbsp; &nbsp; <img style=\"max-width:100%\" alt=\"地方政府救市哪家强？广州补贴上万元，广深杭新增指标超5万\" src=\"https://img.36krcdn.com/20200410/v2_0575c4ed5e5249078095d5db742a479b_img_000\" data-img-size-val=\"1357,770\"> </p> ↵<p    class=\"img-desc\">&nbsp; &nbsp;&nbsp; 来源：乘联会 <br></p> ↵<p>中国汽车业逐步恢复正轨，部分得益于政策推动。 <br></p> ↵<p>3月31日，国务院常务会议决定将新能源汽车购置补贴和免征购置税政策延长2年；中央财政以奖代补，支持京津冀等重点地区淘汰国三及以下排放标准柴油货车；从今年5月1日至2023年底，二手车经销企业销售旧车减按销售额0.5%征收增值税。 <br></p> ↵<p>地方政府也已先后行动起来。截至目前，北京、广州、佛山、杭州、长沙等十数个城市出手救市，出台政策促进汽车消费。目前来看，各地刺激消费的方式大致相同，以购车专项奖励、发放购车及报废旧车补贴为主。此外，备受诟病的购车摇号政策也悄然出现松动，广州、深圳、杭州等地已宣布增加数额不等的购车指标。</p> ↵<h3  >广州出手最大方</h3> ↵<p>作为中国首个十万亿GDP大省，广东已经连续31年蝉联全国经济第一。2019年，广东省以10.7万亿的GDP总量超过了全球90%以上的国家。拥有强大的经济实力做后盾，广东省成为这一轮政策救市的先锋。 <br></p> ↵<p>2月3日，佛山成为第一个出手救市的城市，鼓励消费者购买“国六”标准排量汽车，给予每辆车2000-5000元不等的补贴。广州、珠海、长沙、杭州等地相继跟进。其中，广州补贴力度最大、范围最广，并着重鼓励消费者购买新能源汽车。 <br></p> ↵<p>3月5日，广州市政府宣布在使用环节对个人消费者购买新能源汽车给予1万元补贴，置换或报废二手车的消费者，如购买国六标准新车给予补助3000元。4月3日，广州市商务局针对上述两类消费者再追加4.5亿元消费补贴。 <br></p> ↵<p>佛山、长春补贴范围也涵盖了新车购买和旧车置换，金额分别为2000-3000元、4000-5000元。这两个城市还鼓励集体采购，佛山规定如同一消费者一次性购买的大、中、重型客运、载货汽车（车辆单价不少于50万元）达到5台及以上，每辆车补助可达5000元。长春则规定集体采购5台及以上（单价超过20万元）的新车，每车补助不超过6000元。 <br></p> ↵<p>宁波推出的补贴规则更加宽松，消费者购买宁波本地生产、销售的乘用车并在本地上牌的，给予每辆车一次性让利5000元，无需旧车发票或报废证明。此外，重庆、南昌、湘潭、长沙、山西等地推出的补贴标准为500-6000元不等。 <br></p> ↵<p>另有一些城市政策侧重点有所不同。四川面向全国农村消费者推出补贴政策，买车补贴1000元起。广州的政策除了消费者，还惠及车企，对广州市整车制造企业补贴消费者竞价费用达到每辆车1万元，广州市财政相应给予广州整车制造企业每辆车5000元奖励。此外，广州还推动汽车注册登记和车辆购置税信息网上审核，实现车辆登记上牌 “零跑动”。 <br></p> ↵<p>崔东树接受未来汽车日报（ID：auto-time）采访时表示，目前各地政府补贴金额大致为2000-5000元。</p> ↵<h3  >限购政策悄然松动</h3> ↵<p>2019年9月12日，贵阳市政府正式宣布废除汽车限购措施，并取消“购车摇号”，成为全国首个取消汽车限购的城市。 <br></p> ↵<p>车市寒冬遭遇疫情雪上加霜，业内专家纷纷呼吁松绑汽车限购。 <br></p> ↵<p>中汽协副秘书长叶盛基建议相关部门出台政策刺激汽车消费，提议“限购地区适当增加汽车号牌配额”。崔东树表示，增加购车指标可以“有针对性拉动首购群体消费”。中国汽车流通协会副秘书长郎学红则认为，这么做“能够立竿见影地促进汽车消费”。 <br></p> ↵<p>因为，被限购政策束缚的是一个数字庞大的群体。仅以北京为例，据北京市小客车指标调控管理办公室发布的数据，截至2020年2月8日24时，北京市普通小客车指标申请个人共有3350538个有效编码，配置个人普通小客车指标6417个。也就是说，目前北京有超过335万人有购车意愿，但中签率仅1:522。 <br></p> ↵<p>3月24日，商务部发文宣布北京将新增10万个新能源购车指标，一经发布便引发热议，被解读为坚若磐石的北京购车摇号政策松动的信号。随后，这项政策被紧急撤回，并官方致歉称“未经研究论证”。 <br></p> ↵<p>北京新增购车指标事件只是一次“乌龙”，却似乎为其他限购城市吹响了松绑的号角。 <br></p> ↵<p>4月9日，深圳市交通运输局宣布，面向个人配置1万个混合动力小汽车指标，只能用于新购车辆上牌。4月8日，广州市中小客车调控部门通知，4月广州将新增中小客车指标共17089个，总配置指标数较3月增加近70%。更早些时候，杭州市小客车总量调控管理办公室宣布2020年将一次性增加2万个小客车指标。 <br></p> ↵<p>此外，上海等地已在酝酿释放更多购车指标，促进新车销售。</p> ↵<h3  >亟待更多细则出台</h3> ↵<p>与广州、长沙等地以补贴促进新车消费不同，北京把救市的目光聚焦在存量市场。 <br></p> ↵<p>3月30日，北京宣布今年4月1日-12月31日期间，提前报废或转出的国三车型车主可享受2000元-2.2万元不等的补贴。这项政策的意义，在于促进高排放老旧机动车淘汰更新，优化机动车存量结构。相比刺激首购，北京着力促进换购消费，在存量市场寻求车市的突破点。 <br></p> ↵<p>麦肯锡的一份报告指出，2019年，购车群体中增换购比例比2017年显著提升，换购比重由10%增至23%，增购人群增至7%。这意味着，存量市场正在崛起。 <br></p> ↵<p>据未来汽车日报（ID：auto-time）不完全统计，目前已有至少14个城市出台政策刺激汽车消费。但中国汽车工程学会名誉理事长付于武认为，目前出台的政策还不够，国家和地方政府还应该持续推出更有力的政策。 <br></p> ↵<p>乘联会秘书长崔东树接受未来汽车日报（ID：auto-time）采访时表示，政策密集发布，确实使汽车市场产生波动。不过，部分地区虽然出台了促进汽车消费政策，但执行细节不清晰，消费者仍在观望国家层面的促消费政策。因此，“各地政策落地效果并不突出，月末零售量提升有所放缓”。 <br></p> ↵<p>崔东树表示，补贴力度应该能产生一定拉动消费的效果，但是“各地并没有出台补贴细则，加之各地财政状况吃紧，消费者想真正拿到这笔补贴很难，因此补贴效果大打折扣”。 <br></p> ↵<p>4月2日，商务部消费促进司副司长王斌表示，要促进稳定新车销售，推动有关地方放宽或取消限购措施。4月7日，工信部公布修改版《新能源汽车生产企业及产品准入管理规定》并公开征求意见，进一步放宽新能源汽车生产企业及产品准入门槛。 <br></p> ↵<p>在国家层面政策的带动下，未来或将有更多地方政府推出救市政策。 <br></p> ↵<p>4月8日零时起，武汉正式解封，被疫情阴霾笼罩许久的汽车业逐步回到正轨。在政策推动下，再加上车企采取种种自救措施，崔东树认为，“3月车市触底反弹，4月车市会更好”。</p> ↵<p><img style=\"max-width:100%\" alt=\"地方政府救市哪家强？广州补贴上万元，广深杭新增指标超5万\" src=\"https://img.36krcdn.com/20200410/v2_4494b0ad1e0b4f4d999c9a903ba90c8b_img_gif\" data-img-size-val=\"900,500\"></p> ↵', 'yes', '2020-04-24 12:07:20', '吉良吉影', '这是摘要！');
INSERT INTO `article` VALUES ('3', 'article', 'https://img.cdn.aliyun.dcloud.net.cn/uni-app/doc/uni-app-frame-0310.png', '荒木画展2荒木画展2', '荒木画展，看最正宗的JOJO画风，摆最帅气的JO立。荒木画展，看最正宗的JOJO画风，摆最帅气的JO立。', 'yes', '2020-04-24 12:07:23', '吉良吉影', '什么是JOJO?');
INSERT INTO `article` VALUES ('4', 'article', 'https://img.cdn.aliyun.dcloud.net.cn/uni-app/doc/uni-app-frame-0310.png', '荒木画展3荒木画展2荒木画展2', '荒木画展，看最正宗的JOJO画风，摆最帅气的JO立。', 'yes', '2020-04-24 12:07:25', '吉良吉影', '什么是JOJO?');
INSERT INTO `article` VALUES ('5', 'article', 'https://img.cdn.aliyun.dcloud.net.cn/uni-app/doc/uni-app-frame-0310.png', '荒木画展4', '荒木画展，看最正宗的JOJO画风，摆最帅气的JO立。荒木画展，看最正宗的JOJO画风，摆最帅气的JO立。荒木画展，看最正宗的JOJO画风，摆最帅气的JO立。荒木画展，看最正宗的JOJO画风，摆最帅气的JO立。荒木画展，看最正宗的JOJO画风，摆最帅气的JO立。', 'yes', '2020-04-24 12:07:28', '吉良吉影', '什么是JOJO?');
INSERT INTO `article` VALUES ('6', 'article', 'https://img.cdn.aliyun.dcloud.net.cn/uni-app/doc/run1x9.jpg', '荒木画展5', '荒木画展，看最正宗的JOJO画风，摆最帅气的JO立。', 'yes', '2020-04-24 12:07:31', '吉良吉影', '什么是JOJO?');
INSERT INTO `article` VALUES ('7', 'case', 'https://img.cdn.aliyun.dcloud.net.cn/uni-app/doc/run1x9.jpg', '荒木画展11', '摆最最正宗的JOJO画风，摆最帅气的JO立。', 'yes', '2020-04-24 12:07:34', '吉良吉影', '什么是JOJO?');
INSERT INTO `article` VALUES ('8', 'case', 'https://img.cdn.aliyun.dcloud.net.cn/uni-app/doc/run1x9.jpg', '荒木画展22', '荒木画展，看最正宗的JOJO画风，摆最帅气的JO立。', 'yes', '2020-04-24 12:07:36', '吉良吉影', '什么是JOJO?');
INSERT INTO `article` VALUES ('9', 'case', 'https://img.cdn.aliyun.dcloud.net.cn/uni-app/doc/run1x9.jpg', '荒木画展33', '荒木画展，看最正宗的JOJO画风，摆最帅气的JO立。荒木画展，看最正宗的JOJO画风，摆最帅气的JO立。荒木画展，看最正宗的JOJO画风，摆最帅气的JO立。荒木画展，看最正宗的JOJO画风，', 'yes', '2020-04-24 12:07:38', '吉良吉影', '什么是JOJO?');
INSERT INTO `article` VALUES ('10', 'case', 'https://img.cdn.aliyun.dcloud.net.cn/uni-app/doc/run1x9.jpg', '荒木画展44', '荒木画展，看最正宗的JOJO画风，摆最帅气的JO立。', 'yes', '2020-04-24 12:07:42', '吉良吉影', '什么是JOJO?');
INSERT INTO `article` VALUES ('11', 'case', 'https://img.cdn.aliyun.dcloud.net.cn/uni-app/doc/run1x9.jpg', '荒木画展55', '荒木画展，看最正宗的JOJO画风，摆最帅气的JO立。荒木画展，看最正宗的JOJO画风，摆最帅气的JO立。荒木画展，看最正宗的JOJO画风，摆最帅气的JO立。荒木画展，看最正宗的JOJO画风，', 'yes', '2020-04-24 12:07:47', '吉良吉影', '什么是JOJO?');
INSERT INTO `article` VALUES ('12', 'case', 'https://img.cdn.aliyun.dcloud.net.cn/uni-app/doc/run1x9.jpg', '荒木画展00', '荒木画展，看最正宗的JOJO画风，摆最帅气的JO立。', 'yes', '2020-04-24 12:07:59', '吉良吉影', '什么是JOJO?');

-- ----------------------------
-- Table structure for article_comment
-- ----------------------------
DROP TABLE IF EXISTS `article_comment`;
CREATE TABLE `article_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论表',
  `p_id` bigint(20) DEFAULT '0' COMMENT '评论置顶 1 置顶0 普通',
  `c_id` bigint(20) DEFAULT NULL COMMENT '文章id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `status` varchar(255) DEFAULT 'yes' COMMENT '状态',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `create_time` datetime DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_comment
-- ----------------------------
INSERT INTO `article_comment` VALUES ('1', '1', '1', '1', 'no', '写的好', '2020-03-27 19:10:04');
INSERT INTO `article_comment` VALUES ('2', null, '5', '1', null, '我吉良吉影为你点赞！！', '2020-04-24 14:44:31');
INSERT INTO `article_comment` VALUES ('3', null, '5', '28', null, 'ssdfsdsdfssdfsdfsd', '2020-04-24 14:50:53');
INSERT INTO `article_comment` VALUES ('4', null, '6', '28', null, 'asdfsd', '2020-04-24 15:21:30');
INSERT INTO `article_comment` VALUES ('5', '0', '1', '1', 'yes', 'adsf', '2020-04-24 15:31:35');
INSERT INTO `article_comment` VALUES ('6', null, '5', '28', null, 'sdafsdfsdf', '2020-04-24 15:36:22');
INSERT INTO `article_comment` VALUES ('7', '0', '1', '1', 'yes', '我吉良吉影为你点赞！', '2020-04-24 15:45:40');
INSERT INTO `article_comment` VALUES ('8', '0', '1', '28', 'yes', 'fasd胜多负少打发', '2020-04-24 16:09:19');
INSERT INTO `article_comment` VALUES ('9', '0', '5', '28', 'yes', '打法是否', '2020-04-24 16:11:12');
INSERT INTO `article_comment` VALUES ('10', '0', '6', '28', 'yes', '不错哦', '2020-04-24 16:22:58');
INSERT INTO `article_comment` VALUES ('11', '0', '6', '28', 'yes', '不错哦阿斯蒂芬接口', '2020-04-24 16:23:02');
INSERT INTO `article_comment` VALUES ('12', '0', '5', '28', 'yes', 'sdfasdf', '2020-04-24 16:36:41');
INSERT INTO `article_comment` VALUES ('13', '0', '5', '28', 'yes', 'sdfasdfsdfsdf', '2020-04-24 16:36:45');
INSERT INTO `article_comment` VALUES ('14', '0', '2', '28', 'yes', 'kk\'d\'l看到了就分手了打开房间阿萨德六块腹肌a\'s阿萨德考虑房价大连房价大路口附近dsa大路口附近dsa大路口附近dsa答复收到了房价打了卡', '2020-04-24 16:42:58');
INSERT INTO `article_comment` VALUES ('15', '0', '6', '28', 'yes', '阿斯顿发送到', '2020-04-24 17:17:27');
INSERT INTO `article_comment` VALUES ('16', '0', '6', '28', 'yes', '阿斯蒂芬j\'s\'da\'f\'j\'d\'sa\'l\'k\'f阿斯蒂芬技术大飞机的撒六块腹肌阿萨德积分大立科技发打发', '2020-04-24 17:18:21');
INSERT INTO `article_comment` VALUES ('17', '0', '5', '28', 'yes', '胜多负少的', '2020-04-24 17:19:33');
INSERT INTO `article_comment` VALUES ('18', '0', '2', '28', 'yes', 'sa啥的积分拉数据库', '2020-04-24 17:22:01');
INSERT INTO `article_comment` VALUES ('19', '0', '4', '28', 'yes', 'dsfsaasdf', '2020-04-24 21:57:31');
INSERT INTO `article_comment` VALUES ('20', '0', '1', '28', 'yes', 'dfsd', '2020-04-25 08:50:21');
INSERT INTO `article_comment` VALUES ('21', '0', '11', '28', 'yes', 'dsfs', '2020-04-25 14:20:25');
INSERT INTO `article_comment` VALUES ('22', '0', '2', '13', 'yes', '测试评论', '2020-04-26 14:16:57');
INSERT INTO `article_comment` VALUES ('23', '0', '2', '13', 'yes', '1', '2020-04-26 14:20:01');
INSERT INTO `article_comment` VALUES ('24', '0', '2', '13', 'yes', '测试评论', '2020-04-26 14:20:35');
INSERT INTO `article_comment` VALUES ('25', '0', '2', '13', 'yes', 'ceshi', '2020-04-26 14:21:43');
INSERT INTO `article_comment` VALUES ('26', '0', '8', '28', 'yes', 'asdfsdfa', '2020-04-27 12:45:47');

-- ----------------------------
-- Table structure for banner
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'banner',
  `sort` int(255) DEFAULT NULL,
  `t_id` bigint(20) DEFAULT NULL COMMENT '跳转的文章id',
  `img` varchar(255) DEFAULT NULL COMMENT '图片路径',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of banner
-- ----------------------------
INSERT INTO `banner` VALUES ('2', '1', '1', 'https://oopsstatic.oss-cn-beijing.aliyuncs.com/1580957207997.jpg', null);
INSERT INTO `banner` VALUES ('3', '2', '2', 'https://oopsstatic.oss-cn-beijing.aliyuncs.com/1580957207997.jpg', null);
INSERT INTO `banner` VALUES ('4', '3', '3', 'https://oopsstatic.oss-cn-beijing.aliyuncs.com/1580957207997.jpg', null);

-- ----------------------------
-- Table structure for brace_msg
-- ----------------------------
DROP TABLE IF EXISTS `brace_msg`;
CREATE TABLE `brace_msg` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '方案详情',
  `b_id` bigint(20) DEFAULT NULL COMMENT '方案id',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `num` int(11) DEFAULT NULL COMMENT '佩戴天数',
  `start_time` date DEFAULT NULL COMMENT '开始时间',
  `end_time` date DEFAULT NULL COMMENT '结束时间',
  `status` varchar(255) DEFAULT 'no' COMMENT '状态 未制作 已确认',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `affirm_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of brace_msg
-- ----------------------------
INSERT INTO `brace_msg` VALUES ('72', null, '第2副', '14', '2020-05-12', '2020-05-25', 'yes', '1', '2020-04-28 13:09:56', null, '2020-04-28 13:24:13');
INSERT INTO `brace_msg` VALUES ('73', null, '第3副', '14', '2020-05-26', '2020-06-08', 'yes', '1', '2020-04-28 13:09:56', null, '2020-04-28 13:24:13');
INSERT INTO `brace_msg` VALUES ('74', null, '第4副', '14', '2020-06-09', '2020-06-22', 'yes', '1', '2020-04-28 13:09:56', null, '2020-04-28 13:24:13');
INSERT INTO `brace_msg` VALUES ('75', null, '第5副', '14', '2020-06-23', '2020-07-06', 'yes', '1', '2020-04-28 13:09:57', null, '2020-04-28 13:24:13');
INSERT INTO `brace_msg` VALUES ('76', null, '第6副', '14', '2020-07-07', '2020-07-20', 'yes', '1', '2020-04-28 13:09:57', null, '2020-04-28 13:24:13');
INSERT INTO `brace_msg` VALUES ('77', null, '第7副', '14', '2020-07-21', '2020-08-03', 'yes', '1', '2020-04-28 13:09:57', null, '2020-04-28 13:24:13');
INSERT INTO `brace_msg` VALUES ('78', null, '第8副', '14', '2020-08-04', '2020-08-17', 'yes', '1', '2020-04-28 13:09:57', null, '2020-04-28 13:24:13');
INSERT INTO `brace_msg` VALUES ('79', null, '第9副', '14', '2020-08-18', '2020-08-31', 'yes', '1', '2020-04-28 13:09:57', null, '2020-04-28 13:24:13');
INSERT INTO `brace_msg` VALUES ('80', null, '第10副', '14', '2020-09-01', '2020-09-14', 'yes', '1', '2020-04-28 13:09:58', null, '2020-04-28 13:24:13');
INSERT INTO `brace_msg` VALUES ('81', null, '第11副', '14', '2020-09-15', '2020-09-28', 'yes', '1', '2020-04-28 13:09:58', null, '2020-04-28 13:25:43');
INSERT INTO `brace_msg` VALUES ('82', null, '第12副', '14', '2020-09-29', '2020-10-12', 'yes', '1', '2020-04-28 13:09:58', null, '2020-04-28 13:25:43');
INSERT INTO `brace_msg` VALUES ('83', null, '第13副', '14', '2020-10-13', '2020-10-26', 'yes', '1', '2020-04-28 13:09:58', null, '2020-04-28 13:25:43');
INSERT INTO `brace_msg` VALUES ('84', null, '第14副', '14', '2020-10-27', '2020-11-09', 'yes', '1', '2020-04-28 13:09:58', null, '2020-04-28 13:25:43');
INSERT INTO `brace_msg` VALUES ('85', null, '第15副', '14', '2020-11-10', '2020-11-23', 'yes', '1', '2020-04-28 13:09:59', null, '2020-04-28 13:25:43');
INSERT INTO `brace_msg` VALUES ('86', null, '第16副', '14', '2020-11-24', '2020-12-07', 'yes', '1', '2020-04-28 13:09:59', null, '2020-04-28 13:25:43');
INSERT INTO `brace_msg` VALUES ('87', null, '第17副', '14', '2020-12-08', '2020-12-21', 'yes', '1', '2020-04-28 13:09:59', null, '2020-04-28 13:25:43');
INSERT INTO `brace_msg` VALUES ('88', null, '第18副', '14', '2020-12-22', '2021-01-04', 'yes', '1', '2020-04-28 13:09:59', null, '2020-04-28 13:25:43');
INSERT INTO `brace_msg` VALUES ('89', null, '第19副', '14', '2021-01-05', '2021-01-18', 'yes', '1', '2020-04-28 13:09:59', null, '2020-04-28 13:25:43');
INSERT INTO `brace_msg` VALUES ('90', null, '第20副', '14', '2021-01-19', '2021-02-01', 'yes', '1', '2020-04-28 13:10:00', null, '2020-04-28 13:25:43');
INSERT INTO `brace_msg` VALUES ('91', null, '第21副', '14', '2021-02-02', '2021-02-15', 'yes', '1', '2020-04-28 13:10:00', null, '2020-04-28 13:26:08');
INSERT INTO `brace_msg` VALUES ('92', null, '第22副', '14', '2021-02-16', '2021-03-01', 'yes', '1', '2020-04-28 13:10:00', null, '2020-04-28 13:26:08');
INSERT INTO `brace_msg` VALUES ('93', null, '第23副', '14', '2021-03-02', '2021-03-15', 'yes', '1', '2020-04-28 13:10:00', null, '2020-04-28 13:26:08');
INSERT INTO `brace_msg` VALUES ('94', null, '第24副', '14', '2021-03-16', '2021-03-29', 'yes', '1', '2020-04-28 13:10:00', null, '2020-04-28 13:26:08');
INSERT INTO `brace_msg` VALUES ('95', null, '第25副', '14', '2021-03-30', '2021-04-12', 'yes', '1', '2020-04-28 13:10:01', null, '2020-04-28 13:26:08');
INSERT INTO `brace_msg` VALUES ('96', null, '第26副', '14', '2021-04-13', '2021-04-26', 'yes', '1', '2020-04-28 13:10:01', null, '2020-04-28 13:26:08');
INSERT INTO `brace_msg` VALUES ('97', null, '第27副', '14', '2021-04-27', '2021-05-10', 'yes', '1', '2020-04-28 13:10:01', null, '2020-04-28 13:26:08');
INSERT INTO `brace_msg` VALUES ('98', null, '第28副', '14', '2021-05-11', '2021-05-24', 'yes', '1', '2020-04-28 13:10:01', null, '2020-04-28 13:26:08');
INSERT INTO `brace_msg` VALUES ('99', null, '第29副', '14', '2021-05-25', '2021-06-07', 'yes', '1', '2020-04-28 13:10:01', null, '2020-04-28 13:26:08');
INSERT INTO `brace_msg` VALUES ('100', null, '第30副', '14', '2021-06-08', '2021-06-21', 'yes', '1', '2020-04-28 13:10:02', null, '2020-04-28 13:26:08');
INSERT INTO `brace_msg` VALUES ('101', null, '第31副', '14', '2021-06-22', '2021-07-05', 'no', '1', '2020-04-28 13:10:02', null, null);
INSERT INTO `brace_msg` VALUES ('102', null, '第32副', '14', '2021-07-06', '2021-07-19', 'no', '1', '2020-04-28 13:10:02', null, null);
INSERT INTO `brace_msg` VALUES ('103', null, '第33副', '14', '2021-07-20', '2021-08-02', 'no', '1', '2020-04-28 13:10:02', null, null);
INSERT INTO `brace_msg` VALUES ('104', null, '第34副', '14', '2021-08-03', '2021-08-16', 'no', '1', '2020-04-28 13:10:03', null, null);
INSERT INTO `brace_msg` VALUES ('105', null, '第35副', '14', '2021-08-17', '2021-08-30', 'no', '1', '2020-04-28 13:10:03', null, null);
INSERT INTO `brace_msg` VALUES ('106', null, '第36副', '14', '2021-08-31', '2021-09-13', 'no', '1', '2020-04-28 13:10:03', null, null);
INSERT INTO `brace_msg` VALUES ('107', null, '第37副', '14', '2021-09-14', '2021-09-27', 'no', '1', '2020-04-28 13:10:03', null, null);
INSERT INTO `brace_msg` VALUES ('108', null, '第38副', '14', '2021-09-28', '2021-10-11', 'no', '1', '2020-04-28 13:10:03', null, null);
INSERT INTO `brace_msg` VALUES ('109', null, '第39副', '14', '2021-10-12', '2021-10-25', 'no', '1', '2020-04-28 13:10:04', null, null);
INSERT INTO `brace_msg` VALUES ('110', null, '第40副', '14', '2021-10-26', '2021-11-08', 'no', '1', '2020-04-28 13:10:04', null, null);
INSERT INTO `brace_msg` VALUES ('111', null, '第41副', '14', '2021-11-09', '2021-11-22', 'no', '1', '2020-04-28 13:10:04', null, null);
INSERT INTO `brace_msg` VALUES ('112', null, '第42副', '14', '2021-11-23', '2021-12-06', 'no', '1', '2020-04-28 13:10:04', null, null);
INSERT INTO `brace_msg` VALUES ('113', null, '第43副', '14', '2021-12-07', '2021-12-20', 'no', '1', '2020-04-28 13:10:04', null, null);
INSERT INTO `brace_msg` VALUES ('114', null, '第44副', '14', '2021-12-21', '2022-01-03', 'no', '1', '2020-04-28 13:10:05', null, null);
INSERT INTO `brace_msg` VALUES ('115', null, '第45副', '14', '2022-01-04', '2022-01-17', 'no', '1', '2020-04-28 13:10:05', null, null);
INSERT INTO `brace_msg` VALUES ('116', null, '第46副', '14', '2022-01-18', '2022-01-31', 'no', '1', '2020-04-28 13:10:05', null, null);
INSERT INTO `brace_msg` VALUES ('117', null, '第47副', '14', '2022-02-01', '2022-02-14', 'no', '1', '2020-04-28 13:10:05', null, null);
INSERT INTO `brace_msg` VALUES ('118', null, '第48副', '14', '2022-02-15', '2022-02-28', 'no', '1', '2020-04-28 13:10:05', null, null);
INSERT INTO `brace_msg` VALUES ('119', null, '第49副', '14', '2022-03-01', '2022-03-14', 'no', '1', '2020-04-28 13:10:06', null, null);
INSERT INTO `brace_msg` VALUES ('121', null, '第50副', '14', '2022-03-15', '2022-03-29', 'no', '1', null, null, null);

-- ----------------------------
-- Table structure for consult
-- ----------------------------
DROP TABLE IF EXISTS `consult`;
CREATE TABLE `consult` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `read` varchar(255) DEFAULT NULL,
  `cation` varchar(255) DEFAULT NULL COMMENT '标识',
  `doctor_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of consult
-- ----------------------------
INSERT INTO `consult` VALUES ('1', '11', 'no', '2020-03-31 15:39:52', 'sdfas', 'yes', 'user', '11');
INSERT INTO `consult` VALUES ('2', '11', 'yes', '2020-03-31 15:40:33', '内容', 'no', 'user', '11');
INSERT INTO `consult` VALUES ('3', '11', 'yes', '2020-03-31 07:40:59', '咋回事啊，睡了一觉牙套松了', 'no', 'user', '1');
INSERT INTO `consult` VALUES ('4', '11', 'yes', '2020-03-31 07:42:23', '咋回事啊，睡了一觉牙套松了', 'no', 'user', '1');

-- ----------------------------
-- Table structure for consult_img
-- ----------------------------
DROP TABLE IF EXISTS `consult_img`;
CREATE TABLE `consult_img` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '咨询图片',
  `c_id` bigint(20) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of consult_img
-- ----------------------------

-- ----------------------------
-- Table structure for doc
-- ----------------------------
DROP TABLE IF EXISTS `doc`;
CREATE TABLE `doc` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(2000) DEFAULT NULL COMMENT '标题',
  `content` text COMMENT '内容',
  `type` varchar(255) DEFAULT NULL COMMENT '文章/文本 article/text',
  `a_id` bigint(20) DEFAULT NULL COMMENT '文章id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of doc
-- ----------------------------
INSERT INTO `doc` VALUES ('1', '注册登录有什么用？能享受什么服务？', '注册登录有什么用？能享受什么服务？注册登录有什么用？能享受什么服务？注册登录有什么用？能享受什么服务？', 'article', null);
INSERT INTO `doc` VALUES ('3', '怎样用手机号注册？', '怎样用手机号注册？', 'article', null);

-- ----------------------------
-- Table structure for dynamic
-- ----------------------------
DROP TABLE IF EXISTS `dynamic`;
CREATE TABLE `dynamic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '动态方案',
  `user_id` bigint(20) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL COMMENT '类型 front正面 ，left左面 ，right右面 above上面，below下面',
  `img` varchar(255) DEFAULT NULL COMMENT '图片路径',
  `create_time` datetime DEFAULT NULL,
  `sort` bigint(255) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dynamic
-- ----------------------------
INSERT INTO `dynamic` VALUES ('1', '1', 'front', 'http://localhost/123.jpg', '2020-03-29 08:42:34', '1');
INSERT INTO `dynamic` VALUES ('3', '28', 'front', 'https://knorr.oss-cn-beijing.aliyuncs.com/static/c-img/a-2.png', '2020-04-28 08:42:12', null);
INSERT INTO `dynamic` VALUES ('4', '28', 'front', 'https://knorr.oss-cn-beijing.aliyuncs.com/static/c-img/a-3.png', null, null);
INSERT INTO `dynamic` VALUES ('5', '28', 'front', 'https://knorr.oss-cn-beijing.aliyuncs.com/static/c-img/a-7.png', null, null);
INSERT INTO `dynamic` VALUES ('6', '28', 'front', 'https://knorr.oss-cn-beijing.aliyuncs.com/static/c-img/a-8.png', null, null);
INSERT INTO `dynamic` VALUES ('7', '28', 'front', 'https://knorr.oss-cn-beijing.aliyuncs.com/static/c-img/b-4.png', null, null);
INSERT INTO `dynamic` VALUES ('8', '28', 'front', 'https://knorr.oss-cn-beijing.aliyuncs.com/static/c-img/d-5s.png', null, null);
INSERT INTO `dynamic` VALUES ('9', '28', 'left', 'https://knorr.oss-cn-beijing.aliyuncs.com/static/c-img/d-6.png', null, null);
INSERT INTO `dynamic` VALUES ('10', '28', 'left', 'https://knorr.oss-cn-beijing.aliyuncs.com/static/c-img/d-4.png', null, null);
INSERT INTO `dynamic` VALUES ('11', '28', 'left', 'https://knorr.oss-cn-beijing.aliyuncs.com/static/c-img/e-5s.png', null, null);
INSERT INTO `dynamic` VALUES ('12', '28', 'left', 'https://knorr.oss-cn-beijing.aliyuncs.com/static/c-img/f-5.png', null, null);
INSERT INTO `dynamic` VALUES ('13', '28', 'right', 'https://knorr.oss-cn-beijing.aliyuncs.com/static/c-img/f-4.png', null, null);
INSERT INTO `dynamic` VALUES ('14', '28', 'right', 'https://knorr.oss-cn-beijing.aliyuncs.com/static/c-img/f-3.png', null, null);
INSERT INTO `dynamic` VALUES ('15', '28', 'right', 'https://knorr.oss-cn-beijing.aliyuncs.com/static/c-img/e-8.png', null, null);
INSERT INTO `dynamic` VALUES ('16', '28', 'right', 'https://knorr.oss-cn-beijing.aliyuncs.com/static/c-img/e-6.png', null, null);
INSERT INTO `dynamic` VALUES ('17', '28', 'above', 'https://knorr.oss-cn-beijing.aliyuncs.com/static/c-img/e-7.png', null, null);
INSERT INTO `dynamic` VALUES ('18', '28', 'below', 'https://knorr.oss-cn-beijing.aliyuncs.com/static/c-img/c-9.png', null, null);
INSERT INTO `dynamic` VALUES ('19', '28', 'below', 'https://knorr.oss-cn-beijing.aliyuncs.com/static/c-img/c-7.png', null, null);
INSERT INTO `dynamic` VALUES ('20', '28', 'below', 'https://knorr.oss-cn-beijing.aliyuncs.com/static/c-img/c-4.png', null, null);
INSERT INTO `dynamic` VALUES ('21', '28', 'below', 'https://knorr.oss-cn-beijing.aliyuncs.com/static/c-img/c-3.png', null, null);

-- ----------------------------
-- Table structure for inform
-- ----------------------------
DROP TABLE IF EXISTS `inform`;
CREATE TABLE `inform` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` varchar(255) DEFAULT NULL COMMENT '已读/未读',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of inform
-- ----------------------------
INSERT INTO `inform` VALUES ('1', '11', '2020-03-30 08:49:42', 'no', '腾讯游戏用钱创造快乐');
INSERT INTO `inform` VALUES ('2', '-1', '2020-04-28 13:24:13', 'no', '用户：小汶,手机号：15214440324,已确认制作');
INSERT INTO `inform` VALUES ('3', '11', '2020-04-28 13:24:13', 'no', '用户：小汶,手机号：15214440324,已确认制作');
INSERT INTO `inform` VALUES ('4', '-1', '2020-04-28 13:25:42', 'no', '用户：小汶,手机号：15214440324,已确认制作');
INSERT INTO `inform` VALUES ('5', '11', '2020-04-28 13:25:43', 'no', '用户：小汶,手机号：15214440324,已确认制作');
INSERT INTO `inform` VALUES ('6', '-1', '2020-04-28 13:26:08', 'no', '用户：小汶,手机号：15214440324,已确认制作');
INSERT INTO `inform` VALUES ('7', '11', '2020-04-28 13:26:08', 'no', '用户：小汶,手机号：15214440324,已确认制作');

-- ----------------------------
-- Table structure for scheme
-- ----------------------------
DROP TABLE IF EXISTS `scheme`;
CREATE TABLE `scheme` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '方案',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `img` varchar(255) DEFAULT NULL COMMENT '图片路径',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of scheme
-- ----------------------------
INSERT INTO `scheme` VALUES ('1', '13', 'https://oopsstatic.oss-cn-beijing.aliyuncs.com/1580957207997.jpg', '2020-04-26 15:56:42');

-- ----------------------------
-- Table structure for sys_admin
-- ----------------------------
DROP TABLE IF EXISTS `sys_admin`;
CREATE TABLE `sys_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone_number` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_admin
-- ----------------------------
INSERT INTO `sys_admin` VALUES ('1', '666666', '系统', 'f379eaf3c831b04de153469d1bec345e', '1', 'yes');

-- ----------------------------
-- Table structure for sys_key_value
-- ----------------------------
DROP TABLE IF EXISTS `sys_key_value`;
CREATE TABLE `sys_key_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '医生',
  `key` varchar(255) DEFAULT NULL,
  `values` varchar(255) DEFAULT NULL COMMENT '姓名',
  `comment` varchar(255) DEFAULT NULL COMMENT '医疗机构',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_key_value
-- ----------------------------
INSERT INTO `sys_key_value` VALUES ('1', 'head', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg', '默认头像');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单',
  `menu_name` varchar(255) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `url` varchar(5000) DEFAULT NULL,
  `index` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', 'Banner管理', '0', '/', '1', null);
INSERT INTO `sys_menu` VALUES ('2', 'Banner管理', '1', '/', '2', null);
INSERT INTO `sys_menu` VALUES ('3', '系统设置', '0', '/', '3', null);
INSERT INTO `sys_menu` VALUES ('4', '管理人员列表', '3', '/admin/adminRegister,/admin/changePassword,/admin/updateAdminUser,/admin/delAdmins,/admin/getAdminById,', '4', null);
INSERT INTO `sys_menu` VALUES ('5', '角色列表', '3', '/admin/delRoleByIds,/admin/grantAuthority,/admin/getAllRoleMenu,/admin/addRoleGrantAuthority,', '5', null);
INSERT INTO `sys_menu` VALUES ('6', '参数配置', '0', '/', '6', null);
INSERT INTO `sys_menu` VALUES ('7', '参数配置', '6', '/', '7', null);
INSERT INTO `sys_menu` VALUES ('8', '用户管理', '0', '/', '8', null);
INSERT INTO `sys_menu` VALUES ('9', '用户列表', '8', '/', '9', null);
INSERT INTO `sys_menu` VALUES ('10', '说说管理', '9', '/', '10', null);
INSERT INTO `sys_menu` VALUES ('11', '文章管理', '0', '/', '11', null);
INSERT INTO `sys_menu` VALUES ('12', '科普案例', '11', '/', '12', null);
INSERT INTO `sys_menu` VALUES ('13', '医生管理', '0', '/', '13', null);
INSERT INTO `sys_menu` VALUES ('14', '医生列表', '13', '/', '14', null);
INSERT INTO `sys_menu` VALUES ('15', '文档配置', '6', '/', '15', null);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员', '2020-03-27 15:03:51', null);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` varchar(255) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('1', '1', '1', null, null);
INSERT INTO `sys_role_menu` VALUES ('2', '1', '2', null, null);
INSERT INTO `sys_role_menu` VALUES ('3', '1', '3', null, null);
INSERT INTO `sys_role_menu` VALUES ('4', '1', '4', null, null);
INSERT INTO `sys_role_menu` VALUES ('5', '1', '5', null, null);
INSERT INTO `sys_role_menu` VALUES ('6', '1', '6', null, null);
INSERT INTO `sys_role_menu` VALUES ('7', '1', '7', null, null);
INSERT INTO `sys_role_menu` VALUES ('8', '1', '8', null, null);
INSERT INTO `sys_role_menu` VALUES ('9', '1', '9', null, null);
INSERT INTO `sys_role_menu` VALUES ('10', '1', '10', null, null);
INSERT INTO `sys_role_menu` VALUES ('11', '1', '11', null, null);
INSERT INTO `sys_role_menu` VALUES ('12', '1', '12', null, null);
INSERT INTO `sys_role_menu` VALUES ('13', '1', '13', null, null);
INSERT INTO `sys_role_menu` VALUES ('14', '1', '14', null, null);
INSERT INTO `sys_role_menu` VALUES ('15', '1', '15', null, null);

-- ----------------------------
-- Table structure for talk
-- ----------------------------
DROP TABLE IF EXISTS `talk`;
CREATE TABLE `talk` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '说说',
  `content` text COMMENT '内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` varchar(255) DEFAULT 'yes' COMMENT '状态',
  `user_id` bigint(20) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_head` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of talk
-- ----------------------------
INSERT INTO `talk` VALUES ('1', '今天走路牙卡丢了一个，不用花钱拔牙了，好开心！', '2020-03-30 06:33:42', 'yes', '11', '用户_15214440324', 'http://appraisal.oss-cn-beijing.aliyuncs.com/p5WYbG_1571372983615.jpg');
INSERT INTO `talk` VALUES ('2', '啦啦啦啦啦达瓦，看到那我的1232等我佩服你就按盘可能我发劫不复的打我就发比武啦啦啦啦啦达瓦，看到那我的1232等我佩服你就按盘可能我发劫不复的打我就发比武啦啦啦啦啦达瓦，看到那我的1232等我佩服你就按盘可能我发劫不复的打我就发比武', '2020-04-21 11:05:47', 'yes', '13', '欣阳', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg');
INSERT INTO `talk` VALUES ('3', '啦啦啦啦啦达瓦，看到那我的1232等我佩服你就按盘可能我发劫不复的打我就发比武啦啦啦啦啦达瓦，看到那我的1232等我佩服你就按盘可能我发劫不复的打我就发比武啦啦啦啦啦达瓦，看到那我的1232等我佩服你就按盘可能我发劫不复的打我就发比武', '2020-04-21 13:06:25', 'yes', '13', '欣阳', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg');
INSERT INTO `talk` VALUES ('4', '啦啦啦啦啦达瓦，看到那我的1232等我佩服你就按盘可能我发劫不复的打我就发比武啦啦啦啦啦达瓦，看到那我的1232等我佩服你就按盘可能我发劫不复的打我就发比武啦啦啦啦啦达瓦，看到那我的1232等我佩服你就按盘可能我发劫不复的打我就发比武', '2020-04-21 10:06:25', 'yes', '13', '欣阳', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg');
INSERT INTO `talk` VALUES ('5', '啦啦啦啦啦达瓦，看到那我的1232等我佩服你就按盘可能我发劫不复的打我就发比武啦啦啦啦啦达瓦，看到那我的1232等我佩服你就按盘可能我发劫不复的打我就发比武啦啦啦啦啦达瓦，看到那我的1232等我佩服你就按盘可能我发劫不复的打我就发比武', '2020-04-21 09:06:25', 'yes', '13', '欣阳', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg');
INSERT INTO `talk` VALUES ('6', '啦啦啦啦啦达瓦，看到那我的1232等我佩服你就按盘可能我发劫不复的打我就发比武啦啦啦啦啦达瓦，看到那我的1232等我佩服你就按盘可能我发劫不复的打我就发比武啦啦啦啦啦达瓦，看到那我的1232等我佩服你就按盘可能我发劫不复的打我就发比武', '2020-04-20 15:06:25', 'yes', '13', '欣阳', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg');
INSERT INTO `talk` VALUES ('7', '啦啦啦啦啦达瓦，看到那我的1232等我佩服你就按盘可能我发劫不复的打我就发比武啦啦啦啦啦达瓦，看到那我的1232等我佩服你就按盘可能我发劫不复的打我就发比武啦啦啦啦啦达瓦，看到那我的1232等我佩服你就按盘可能我发劫不复的打我就发比武', '2020-04-21 03:06:25', 'yes', '13', '欣阳', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg');
INSERT INTO `talk` VALUES ('8', 'fsdfsfsfs', '2020-04-22 23:06:43', 'yes', '28', '用户_15811101990', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg');
INSERT INTO `talk` VALUES ('9', '测试发布说说。1', '2020-04-23 11:50:30', 'yes', '13', '用户_13522149274', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg');
INSERT INTO `talk` VALUES ('10', '测试发布说说2.', '2020-04-23 11:56:11', 'yes', '13', '用户_13522149274', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg');
INSERT INTO `talk` VALUES ('11', 'dsfsdfsdaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa', '2020-04-23 12:18:53', 'yes', '28', '用户_15811101990', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg');
INSERT INTO `talk` VALUES ('12', '时代峰峻阿萨德联发科静安寺砥砺奋进算了', '2020-04-23 21:05:44', 'yes', '28', '用户_15811101990', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg');
INSERT INTO `talk` VALUES ('13', '时代峰峻阿萨德联发科静安寺砥砺奋进算了', '2020-04-23 21:05:51', 'yes', '28', '用户_15811101990', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg');
INSERT INTO `talk` VALUES ('14', '时代峰峻阿萨德联发科静安寺砥砺奋进算了', '2020-04-23 21:06:39', 'yes', '28', '用户_15811101990', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg');
INSERT INTO `talk` VALUES ('15', '大沙发斯蒂芬', '2020-04-23 21:12:30', 'yes', '28', '用户_15811101990', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg');
INSERT INTO `talk` VALUES ('16', '收费', '2020-04-23 21:13:21', 'yes', '28', '用户_15811101990', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg');
INSERT INTO `talk` VALUES ('17', '阿萨德', '2020-04-23 21:14:59', 'yes', '28', '用户_15811101990', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg');
INSERT INTO `talk` VALUES ('18', '奥德赛阿士大夫撒旦', '2020-04-23 21:37:05', 'yes', '28', '用户_15811101990', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg');
INSERT INTO `talk` VALUES ('19', '不香吗', '2020-04-25 16:20:58', 'yes', '28', '用户_15811101990', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg');
INSERT INTO `talk` VALUES ('20', 'jhkj ', '2020-04-25 16:33:36', 'yes', '28', '用户_15811101990', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg');
INSERT INTO `talk` VALUES ('21', '呵呵', '2020-04-25 16:34:28', 'yes', '28', '用户_15811101990', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg');

-- ----------------------------
-- Table structure for talk_comment
-- ----------------------------
DROP TABLE IF EXISTS `talk_comment`;
CREATE TABLE `talk_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论表',
  `t_id` bigint(11) DEFAULT NULL COMMENT '说说id',
  `content` varchar(2000) DEFAULT NULL COMMENT '评论内容',
  `user_id` bigint(11) DEFAULT NULL COMMENT '用户id',
  `user_name` varchar(255) DEFAULT NULL COMMENT '评论用户名',
  `user_head` varchar(255) DEFAULT NULL COMMENT '评论的用户头像',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` varchar(255) DEFAULT 'yes',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of talk_comment
-- ----------------------------
INSERT INTO `talk_comment` VALUES ('1', '1', '哈哈哈，楼主真是个小天才!', '11', '用户_15214440324', null, '2020-03-30 07:03:42', 'yes');
INSERT INTO `talk_comment` VALUES ('2', '3', 'fsd', '28', '用户_15811101990', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg', '2020-04-22 22:49:29', 'yes');
INSERT INTO `talk_comment` VALUES ('3', '2', 'adsfsada', '28', '用户_15811101990', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg', '2020-04-22 22:49:59', 'yes');
INSERT INTO `talk_comment` VALUES ('4', '8', 'sfsdfs', '28', '用户_15811101990', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg', '2020-04-23 12:08:03', 'yes');
INSERT INTO `talk_comment` VALUES ('5', '10', 'badfsdfsd', '28', '用户_15811101990', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg', '2020-04-23 12:18:42', 'yes');
INSERT INTO `talk_comment` VALUES ('6', '1', 'dsfdsfs', '28', '用户_15811101990', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg', '2020-04-23 12:26:31', 'yes');
INSERT INTO `talk_comment` VALUES ('7', '17', '啊啊是否撒发顺丰s\'f', '28', '用户_15811101990', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg', '2020-04-23 21:15:34', 'yes');
INSERT INTO `talk_comment` VALUES ('8', '18', '11111', '28', '用户_15811101990', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg', '2020-04-23 21:37:32', 'yes');
INSERT INTO `talk_comment` VALUES ('9', '18', '222', '28', '用户_15811101990', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg', '2020-04-23 21:37:36', 'yes');

-- ----------------------------
-- Table structure for talk_img
-- ----------------------------
DROP TABLE IF EXISTS `talk_img`;
CREATE TABLE `talk_img` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `t_id` bigint(20) DEFAULT NULL COMMENT '说说Id',
  `img` varchar(255) DEFAULT NULL COMMENT '图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of talk_img
-- ----------------------------
INSERT INTO `talk_img` VALUES ('1', '1', 'https://knorr.oss-cn-beijing.aliyuncs.com/f-3.png');
INSERT INTO `talk_img` VALUES ('2', '1', 'https://knorr.oss-cn-beijing.aliyuncs.com/f-4.png');
INSERT INTO `talk_img` VALUES ('3', '1', 'https://knorr.oss-cn-beijing.aliyuncs.com/f-5.png');
INSERT INTO `talk_img` VALUES ('4', '2', 'https://knorr.oss-cn-beijing.aliyuncs.com/f-3.png');
INSERT INTO `talk_img` VALUES ('5', '3', 'https://knorr.oss-cn-beijing.aliyuncs.com/f-3.png');
INSERT INTO `talk_img` VALUES ('6', '3', 'https://knorr.oss-cn-beijing.aliyuncs.com/f-3.png');
INSERT INTO `talk_img` VALUES ('7', '9', 'https://knorr.oss-cn-beijing.aliyuncs.com/talk/talk_image_2020-4-23_1587613810390_40.png');
INSERT INTO `talk_img` VALUES ('8', '10', 'https://knorr.oss-cn-beijing.aliyuncs.com/talk/talk_image_2020-4-23_1587614088191_79.png');
INSERT INTO `talk_img` VALUES ('9', '16', 'https://knorr.oss-cn-beijing.aliyuncs.com//head/user_head_2020-4-23_1587647592831_25.png');
INSERT INTO `talk_img` VALUES ('10', '16', 'https://knorr.oss-cn-beijing.aliyuncs.com//head/user_head_2020-4-23_1587647596094_49.png');
INSERT INTO `talk_img` VALUES ('11', '17', 'https://knorr.oss-cn-beijing.aliyuncs.com//head/user_head_2020-4-23_1587647694735_28.png');
INSERT INTO `talk_img` VALUES ('12', '18', 'https://knorr.oss-cn-beijing.aliyuncs.com//head/user_head_2020-4-23_1587649012751_46.png');
INSERT INTO `talk_img` VALUES ('13', '18', 'https://knorr.oss-cn-beijing.aliyuncs.com//head/user_head_2020-4-23_1587649016437_68.png');
INSERT INTO `talk_img` VALUES ('14', '18', 'https://knorr.oss-cn-beijing.aliyuncs.com//head/user_head_2020-4-23_1587649020361_62.png');
INSERT INTO `talk_img` VALUES ('15', '20', 'https://knorr.oss-cn-beijing.aliyuncs.com//head/user_head_2020-4-25_1587803611683_62.png');
INSERT INTO `talk_img` VALUES ('16', '21', 'https://knorr.oss-cn-beijing.aliyuncs.com//head/user_head_2020-4-25_1587803655228_91.png');
INSERT INTO `talk_img` VALUES ('17', '21', 'https://knorr.oss-cn-beijing.aliyuncs.com//head/user_head_2020-4-25_1587803663349_75.png');

-- ----------------------------
-- Table structure for talk_like
-- ----------------------------
DROP TABLE IF EXISTS `talk_like`;
CREATE TABLE `talk_like` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户点赞',
  `c_id` bigint(20) DEFAULT NULL COMMENT '说说id',
  `user_id` bigint(11) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of talk_like
-- ----------------------------
INSERT INTO `talk_like` VALUES ('1', '1', '11');
INSERT INTO `talk_like` VALUES ('20', '3', '13');
INSERT INTO `talk_like` VALUES ('22', '2', '28');
INSERT INTO `talk_like` VALUES ('23', '4', '28');
INSERT INTO `talk_like` VALUES ('24', '3', '28');
INSERT INTO `talk_like` VALUES ('26', '8', '28');
INSERT INTO `talk_like` VALUES ('27', '10', '28');
INSERT INTO `talk_like` VALUES ('28', '9', '28');
INSERT INTO `talk_like` VALUES ('29', '10', '13');
INSERT INTO `talk_like` VALUES ('31', '11', '28');
INSERT INTO `talk_like` VALUES ('32', '17', '28');
INSERT INTO `talk_like` VALUES ('36', '21', '28');

-- ----------------------------
-- Table structure for talk_reply
-- ----------------------------
DROP TABLE IF EXISTS `talk_reply`;
CREATE TABLE `talk_reply` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '说说评论回复',
  `c_id` bigint(11) DEFAULT NULL COMMENT '评论id',
  `replay_id` bigint(20) DEFAULT NULL COMMENT '回复用户id',
  `replay_name` varchar(255) DEFAULT NULL COMMENT '回复目标用户名',
  `replay_head` varchar(255) DEFAULT NULL COMMENT '回复目标用户头像',
  `content` varchar(2000) DEFAULT NULL COMMENT '回复内容',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `user_head` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of talk_reply
-- ----------------------------
INSERT INTO `talk_reply` VALUES ('1', '1', '11', '小汶', '1.png', '哈哈哈', '11', '用户_15214440324', null, '2020-03-30 07:25:03');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机号',
  `gender` varchar(255) DEFAULT NULL COMMENT '性别',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `region` varchar(255) DEFAULT NULL COMMENT '地区',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `organ` varchar(255) DEFAULT NULL COMMENT '机构',
  `diagnose` varchar(255) DEFAULT NULL COMMENT '诊断 多个用 ，分割 ',
  `create_time` datetime DEFAULT NULL,
  `password` varchar(500) DEFAULT NULL COMMENT '密码',
  `wxid` varchar(255) DEFAULT NULL COMMENT '微信id',
  `doctor_id` bigint(20) DEFAULT NULL COMMENT '医生id',
  `state` varchar(255) DEFAULT 'underway' COMMENT '诊断状态 ''underway'' 进行中 accomplish完成',
  `head` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT 'yes' COMMENT '账号状态',
  `doctor` varchar(255) DEFAULT 'no' COMMENT '是否是医生',
  `scheme` varchar(255) DEFAULT NULL COMMENT '矫正方案  yes/no',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '小汶', '15214440324', '男', null, '北京', '1997-12-01', '北京医疗小组', '需去釉,需拔牙', '2020-03-28 17:15:21', '985a05d8a82033ce5616481bd8a87507', null, '11', 'underway', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg', 'yes', 'no', null);
INSERT INTO `user` VALUES ('12', '张三', '12345678901', '男', null, '北京', '1997-12-01', '北京医疗小组', '去釉,拔牙', '2020-03-28 17:15:21', null, null, null, '', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg', 'yes', 'yes', null);
INSERT INTO `user` VALUES ('13', '用户_13522149274', '13522149274', '男', '17', '北京市,北京市,朝阳区', null, 'ceshi', '去釉,拔牙,磨牙', '2020-04-14 08:51:47', '58cf703f664397ec4f0ac359b84b565c', null, null, null, 'https://knorr.oss-cn-beijing.aliyuncs.com/head/user_head_2020-4-25_1587803320911_96.png', 'yes', null, null);
INSERT INTO `user` VALUES ('14', '1号用户', '13522149270', '男', null, null, '1997-12-01', null, '需去釉,需拔牙', '2020-04-12 14:56:34', null, null, '13', 'underway', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg', 'yes', 'no', null);
INSERT INTO `user` VALUES ('15', '2号用户', '13522149270', '男', null, null, '1997-12-01', null, '需去釉,需拔牙', '2020-04-12 14:56:34', null, null, '13', 'underway', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg', 'yes', 'no', null);
INSERT INTO `user` VALUES ('16', '3号用户', '13522149270', '男', null, null, '1997-12-01', null, '需去釉,需拔牙', '2020-04-12 14:56:34', null, null, '13', 'underway', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg', 'yes', 'no', null);
INSERT INTO `user` VALUES ('17', '4号用户', '13522149270', '男', null, null, '1997-12-01', null, '需去釉,需拔牙', '2020-04-12 14:56:34', null, null, '13', 'underway', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg', 'yes', 'no', null);
INSERT INTO `user` VALUES ('18', '5号用户', '13522149270', '男', null, null, '1997-12-01', null, '需去釉,需拔牙', '2020-04-12 14:56:34', null, null, '13', 'underway', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg', 'yes', 'no', null);
INSERT INTO `user` VALUES ('19', '6号用户', '13522149270', '男', null, null, '1997-12-01', null, '需去釉,需拔牙', '2020-04-12 14:56:34', null, null, '13', 'underway', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg', 'yes', 'no', null);
INSERT INTO `user` VALUES ('20', '7号用户', '13522149270', '男', null, null, '1997-12-01', null, '需去釉,需拔牙', '2020-04-12 14:56:34', null, null, '13', 'underway', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg', 'yes', 'no', null);
INSERT INTO `user` VALUES ('21', '8号用户', '13522149270', '男', null, null, '1997-12-01', null, '需去釉,需拔牙', '2020-04-12 14:56:34', null, null, '13', 'underway', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg', 'yes', 'no', null);
INSERT INTO `user` VALUES ('22', '9号用户', '13522149270', '男', null, null, '1997-12-01', null, '需去釉,需拔牙', '2020-04-12 14:56:34', null, null, '13', 'underway', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg', 'yes', 'no', null);
INSERT INTO `user` VALUES ('23', '10号用户', '13522149270', '男', null, null, '1997-12-01', null, '需去釉,需拔牙', '2020-04-12 14:56:34', null, null, '13', 'underway', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg', 'yes', 'no', null);
INSERT INTO `user` VALUES ('24', '11号用户', '13522149270', '男', null, null, '1997-12-01', null, '需去釉,需拔牙', '2020-04-12 14:56:34', null, null, '13', 'underway', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg', 'yes', 'no', null);
INSERT INTO `user` VALUES ('25', '12号用户', '13522149270', '男', null, null, '1997-12-01', null, '需去釉,需拔牙', '2020-04-12 14:56:34', null, null, '13', 'underway', 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg', 'yes', 'no', null);
INSERT INTO `user` VALUES ('28', '用户_15811101990', '15811101990', null, null, null, null, null, '去釉,拔牙', '2020-04-21 14:25:04', '2bd12a930c3012f9bb4e0ea9bec9a3fc', null, null, null, 'https://knorr.oss-cn-beijing.aliyuncs.com/25124298_172519481324_2.jpg', 'yes', null, null);
