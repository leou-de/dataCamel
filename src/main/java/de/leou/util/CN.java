package de.leou.util;

public class CN {
	public static String getFullname(String iso2) {
		String s = "";
		switch (iso2) {
		//@formatter:off
		case "AD": s="Andorra" ; break ;
		case "AE": s="United Arab Emirates" ; break ;
		case "AF": s="Afghanistan" ; break ;
		case "AG": s="Antigua and Barbuda" ; break ;
		case "AI": s="Anguilla" ; break ;
		case "AL": s="Albania" ; break ;
		case "AM": s="Armenia" ; break ;

		case "AO": s="Angola" ; break ;
		case "AR": s="Argentina" ; break ;
		case "AT": s="Austria" ; break ;
		case "AU": s="Australia" ; break ;
		case "AZ": s="Azerbaijan" ; break ;
		case "BB": s="Barbados" ; break ;
		case "BD": s="Bangladesh" ; break ;
		case "BE": s="Belgium" ; break ;
		case "BF": s="Burkina-faso" ; break ;
		case "BG": s="Bulgaria" ; break ;
		case "BH": s="Bahrain" ; break ;
		case "BI": s="Burundi" ; break ;
		case "BJ": s="Benin" ; break ;
		case "BL": s="Palestine" ; break ;
		case "BM": s="Bermuda Is." ; break ;
		case "BN": s="Brunei" ; break ;
		case "BO": s="Bolivia" ; break ;
		case "BR": s="Brazil" ; break ;
		case "BS": s="Bahamas" ; break ;
		case "BW": s="Botswana" ; break ;
		case "BY": s="Belarus" ; break ;
		case "BZ": s="Belize" ; break ;
		case "CA": s="Canada" ; break ;

		case "CF": s="Central African Republic" ; break ;
		case "CG": s="Congo" ; break ;
		case "CH": s="Switzerland" ; break ;
		case "CK": s="Cook Is." ; break ;
		case "CL": s="Chile" ; break ;
		case "CM": s="Cameroon" ; break ;
		case "CN": s="China" ; break ;
		case "CO": s="Colombia" ; break ;
		case "CR": s="Costa Rica" ; break ;
		case "CS": s="Czech" ; break ;
		case "CU": s="Cuba" ; break ;
		case "CY": s="Cyprus" ; break ;
		case "CZ": s="Czech Republic" ; break ;
		case "DE": s="Germany" ; break ;
		case "DJ": s="Djibouti" ; break ;
		case "DK": s="Denmark" ; break ;
		case "DO": s="Dominica Rep." ; break ;
		case "DZ": s="Algeria" ; break ;
		case "EC": s="Ecuador" ; break ;
		case "EE": s="Estonia" ; break ;
		case "EG": s="Egypt" ; break ;
		case "ES": s="Spain" ; break ;
		case "ET": s="Ethiopia" ; break ;
		case "FI": s="Finland" ; break ;
		case "FJ": s="Fiji" ; break ;
		case "FR": s="France" ; break ;
		case "GA": s="Gabon" ; break ;
		case "GB": s="United Kiongdom" ; break ;
		case "GD": s="Grenada" ; break ;
		case "GE": s="Georgia" ; break ;
		case "GF": s="French Guiana" ; break ;
		case "GH": s="Ghana" ; break ;
		case "GI": s="Gibraltar" ; break ;
		case "GM": s="Gambia" ; break ;
		case "GN": s="Guinea" ; break ;
		case "GR": s="Greece" ; break ;
		case "GT": s="Guatemala" ; break ;
		case "GU": s="Guam" ; break ;
		case "GY": s="Guyana" ; break ;
		case "HK": s="Hongkong" ; break ;
		case "HN": s="Honduras" ; break ;
		case "HT": s="Haiti" ; break ;
		case "HU": s="Hungary" ; break ;
		case "ID": s="Indonesia" ; break ;
		case "IE": s="Ireland" ; break ;
		case "IL": s="Israel" ; break ;
		case "IN": s="India" ; break ;
		case "IQ": s="Iraq" ; break ;
		case "IR": s="Iran" ; break ;
		case "IS": s="Iceland" ; break ;
		case "IT": s="Italy" ; break ;

		case "JM": s="Jamaica" ; break ;
		case "JO": s="Jordan" ; break ;
		case "JP": s="Japan" ; break ;
		case "KE": s="Kenya" ; break ;
		case "KG": s="Kyrgyzstan" ; break ;
		case "KH": s="Kampuchea (Cambodia )" ; break ;
		case "KP": s="North Korea" ; break ;
		case "KR": s="Korea" ; break ;
		case "KT": s="Republic of Ivory Coast" ; break ;
		case "KW": s="Kuwait" ; break ;
		case "KZ": s="Kazakstan" ; break ;
		case "LA": s="Laos" ; break ;
		case "LB": s="Lebanon" ; break ;
		case "LC": s="St.Lucia" ; break ;
		case "LI": s="Liechtenstein" ; break ;
		case "LK": s="Sri Lanka" ; break ;
		case "LR": s="Liberia" ; break ;
		case "LS": s="Lesotho" ; break ;
		case "LT": s="Lithuania" ; break ;
		case "LU": s="Luxembourg" ; break ;
		case "LV": s="Latvia" ; break ;
		case "LY": s="Libya" ; break ;
		case "MA": s="Morocco" ; break ;
		case "MC": s="Monaco" ; break ;
		case "MD": s="Moldova, Republic of" ; break ;
		case "MG": s="Madagascar" ; break ;
		case "ML": s="Mali" ; break ;
		case "MM": s="Burma" ; break ;
		case "MN": s="Mongolia" ; break ;
		case "MO": s="Macao" ; break ;
		case "MS": s="Montserrat Is" ; break ;
		case "MT": s="Malta" ; break ;


		case "MU": s="Mauritius" ; break ;
		case "MV": s="Maldives" ; break ;
		case "MW": s="Malawi" ; break ;
		case "MX": s="Mexico" ; break ;
		case "MY": s="Malaysia" ; break ;
		case "MZ": s="Mozambique" ; break ;
		case "NA": s="Namibia" ; break ;
		case "NE": s="Niger" ; break ;
		case "NG": s="Nigeria" ; break ;
		case "NI": s="Nicaragua" ; break ;
		case "NL": s="Netherlands" ; break ;
		case "NO": s="Norway" ; break ;
		case "NP": s="Nepal" ; break ;

		case "NR": s="Nauru" ; break ;
		case "NZ": s="New Zealand" ; break ;
		case "OM": s="Oman" ; break ;
		case "PA": s="Panama" ; break ;
		case "PE": s="Peru" ; break ;
		case "PF": s="French Polynesia" ; break ;
		case "PG": s="Papua New Cuinea" ; break ;
		case "PH": s="Philippines" ; break ;
		case "PK": s="Pakistan" ; break ;
		case "PL": s="Poland" ; break ;
		case "PR": s="Puerto Rico" ; break ;
		case "PT": s="Portugal" ; break ;
		case "PY": s="Paraguay" ; break ;
		case "QA": s="Qatar" ; break ;

		case "RO": s="Romania" ; break ;
		case "RU": s="Russia" ; break ;
		case "SA": s="Saudi Arabia" ; break ;
		case "SB": s="Solomon Is" ; break ;
		case "SC": s="Seychelles" ; break ;
		case "SD": s="Sudan" ; break ;
		case "SE": s="Sweden" ; break ;
		case "SG": s="Singapore" ; break ;
		case "SI": s="Slovenia" ; break ;
		case "SK": s="Slovakia" ; break ;
		case "SL": s="Sierra Leone" ; break ;
		case "SM": s="San Marino" ; break ;
		case "SN": s="Senegal" ; break ;
		case "SO": s="Somali" ; break ;
		case "SR": s="Suriname" ; break ;
		case "ST": s="Sao Tome and Principe" ; break ;
		case "SV": s="EI Salvador" ; break ;
		case "SY": s="Syria" ; break ;
		case "SZ": s="Swaziland" ; break ;
		case "TD": s="Chad" ; break ;
		case "TG": s="Togo" ; break ;
		case "TH": s="Thailand" ; break ;
		case "TJ": s="Tajikstan" ; break ;
		case "TM": s="Turkmenistan" ; break ;
		case "TN": s="Tunisia" ; break ;
		case "TO": s="Tonga" ; break ;
		case "TR": s="Turkey" ; break ;
		case "TT": s="Trinidad and Tobago" ; break ;
		case "TW": s="Taiwan" ; break ;
		case "TZ": s="Tanzania" ; break ;
		case "UA": s="Ukraine" ; break ;
		case "UG": s="Uganda" ; break ;
		case "US": s="United States of America" ; break ;
		case "UY": s="Uruguay" ; break ;
		case "UZ": s="Uzbekistan" ; break ;
		case "VC": s="Saint Vincent" ; break ;
		case "VE": s="Venezuela" ; break ;
		case "VN": s="Vietnam" ; break ;
		case "YE": s="Yemen" ; break ;
		case "YU": s="Yugoslavia" ; break ;
		case "ZA": s="South Africa" ; break ;
		case "ZM": s="Zambia" ; break ;
		case "ZR": s="Zaire" ; break ;
		case "ZW": s="Zimbabwe" ; break ;

		
		}
		
		
		return s;
		
	}
	
	/*

国际域名缩写	国家或地区	英文名	电话代码
AD	安道尔共和国	Andorra	376
AE	阿拉伯联合酋长国	United Arab Emirates	971
AF	阿富汗	Afghanistan	93
AG	安提瓜和巴布达	Antigua and Barbuda	1268
AI	安圭拉岛	Anguilla	1264
AL	阿尔巴尼亚	Albania	355
AM	亚美尼亚	Armenia	374
阿森松	Ascension	247
AO	安哥拉	Angola	244
AR	阿根廷	Argentina	54
AT	奥地利	Austria	43
AU	澳大利亚	Australia	61
AZ	阿塞拜疆	Azerbaijan	994
BB	巴巴多斯	Barbados	1246
BD	孟加拉国	Bangladesh	880
BE	比利时	Belgium	32
BF	布基纳法索	Burkina-faso	226
BG	保加利亚	Bulgaria	359
BH	巴林	Bahrain	973
BI	布隆迪	Burundi	257
BJ	贝宁	Benin	229
BL	巴勒斯坦	Palestine	970
BM	百慕大群岛	Bermuda Is.	1441
BN	文莱	Brunei	673
BO	玻利维亚	Bolivia	591
BR	巴西	Brazil	55
BS	巴哈马	Bahamas	1242
BW	博茨瓦纳	Botswana	267
BY	白俄罗斯	Belarus	375
BZ	伯利兹	Belize	501
CA	加拿大	Canada	1
开曼群岛	Cayman Is.	1345
CF	中非共和国	Central African Republic	236
CG	刚果	Congo	242
CH	瑞士	Switzerland	41
CK	库克群岛	Cook Is.	682
CL	智利	Chile	56
CM	喀麦隆	Cameroon	237
CN	中国	China	86
CO	哥伦比亚	Colombia	57
CR	哥斯达黎加	Costa Rica	506
CS	捷克	Czech	420
CU	古巴	Cuba	53
CY	塞浦路斯	Cyprus	357
CZ	捷克	Czech Republic	420
DE	德国	Germany	49
DJ	吉布提	Djibouti	253
DK	丹麦	Denmark	45
DO	多米尼加共和国	Dominica Rep.	1890
DZ	阿尔及利亚	Algeria	213
EC	厄瓜多尔	Ecuador	593
EE	爱沙尼亚	Estonia	372
EG	埃及	Egypt	20
ES	西班牙	Spain	34
ET	埃塞俄比亚	Ethiopia	251
FI	芬兰	Finland	358
FJ	斐济	Fiji	679
FR	法国	France	33
GA	加蓬	Gabon	241
GB	英国	United Kiongdom	44
GD	格林纳达	Grenada	1809
GE	格鲁吉亚	Georgia	995
GF	法属圭亚那	French Guiana	594
GH	加纳	Ghana	233
GI	直布罗陀	Gibraltar	350
GM	冈比亚	Gambia	220
GN	几内亚	Guinea	224
GR	希腊	Greece	30
GT	危地马拉	Guatemala	502
GU	关岛	Guam	1671
GY	圭亚那	Guyana	592
HK	香港特别行政区	Hongkong	852
HN	洪都拉斯	Honduras	504
HT	海地	Haiti	509
HU	匈牙利	Hungary	36
ID	印度尼西亚	Indonesia	62
IE	爱尔兰	Ireland	353
IL	以色列	Israel	972
IN	印度	India	91
IQ	伊拉克	Iraq	964
IR	伊朗	Iran	98
IS	冰岛	Iceland	354
IT	意大利	Italy	39
科特迪瓦	Ivory Coast	225
JM	牙买加	Jamaica	1876
JO	约旦	Jordan	962
JP	日本	Japan	81
KE	肯尼亚	Kenya	254
KG	吉尔吉斯坦	Kyrgyzstan	331
KH	柬埔寨	Kampuchea (Cambodia )	855
KP	朝鲜	North Korea	850
KR	韩国	Korea	82
KT	科特迪瓦共和国	Republic of Ivory Coast	225
KW	科威特	Kuwait	965
KZ	哈萨克斯坦	
Kazakstan

327
LA	老挝	Laos	856
LB	黎巴嫩	Lebanon	961
LC	圣卢西亚	St.Lucia	1758
LI	列支敦士登	Liechtenstein	423
LK	斯里兰卡	Sri Lanka	94
LR	利比里亚	Liberia	231
LS	莱索托	Lesotho	266
LT	立陶宛	Lithuania	370
LU	卢森堡	Luxembourg	352
LV	拉脱维亚	Latvia	371
LY	利比亚	Libya	218
MA	摩洛哥	Morocco	212
MC	摩纳哥	Monaco	377
MD	摩尔多瓦	Moldova, Republic of	373
MG	马达加斯加	Madagascar	261
ML	马里	Mali	223
MM	缅甸	Burma	95
MN	蒙古	Mongolia	976
MO	澳门	Macao	853
MS	蒙特塞拉特岛	Montserrat Is	1664
MT	马耳他	Malta	356
马里亚那群岛	Mariana Is	1670
马提尼克	Martinique	596
MU	毛里求斯	Mauritius	230
MV	马尔代夫	Maldives	960
MW	马拉维	Malawi	265
MX	墨西哥	Mexico	52
MY	马来西亚	Malaysia	60
MZ	莫桑比克	Mozambique	258
NA	纳米比亚	Namibia	264
NE	尼日尔	Niger	977
NG	尼日利亚	Nigeria	234
NI	尼加拉瓜	Nicaragua	505
NL	荷兰	Netherlands	31
NO	挪威	Norway	47
NP	尼泊尔	Nepal	977
荷属安的列斯	Netheriands Antilles	599
NR	瑙鲁	Nauru	674
NZ	新西兰	New Zealand	64
OM	阿曼	Oman	968
PA	巴拿马	Panama	507
PE	秘鲁	Peru	51
PF	法属玻利尼西亚	French Polynesia	689
PG	巴布亚新几内亚	Papua New Cuinea	675
PH	菲律宾	Philippines	63
PK	巴基斯坦	Pakistan	92
PL	波兰	Poland	48
PR	波多黎各	Puerto Rico	1787
PT	葡萄牙	Portugal	351
PY	巴拉圭	Paraguay	595
QA	卡塔尔	Qatar	974
留尼旺	Reunion	262
RO	罗马尼亚	Romania	40
RU	俄罗斯	Russia	7
SA	沙特阿拉伯	Saudi Arabia	966
SB	所罗门群岛	Solomon Is	677
SC	塞舌尔	Seychelles	248
SD	苏丹	Sudan	249
SE	瑞典	Sweden	46
SG	新加坡	Singapore	65
SI	斯洛文尼亚	Slovenia	386
SK	斯洛伐克	Slovakia	421
SL	塞拉利昂	Sierra Leone	232
SM	圣马力诺	San Marino	378
东萨摩亚(美)	Samoa Eastern	684
西萨摩亚	San Marino	685
SN	塞内加尔	Senegal	221
SO	索马里	Somali	252
SR	苏里南	Suriname	597
ST	圣多美和普林西比	Sao Tome and Principe	239
SV	萨尔瓦多	EI Salvador	503
SY	叙利亚	Syria	963
SZ	斯威士兰	Swaziland	268
TD	乍得	Chad	235
TG	多哥	Togo	228
TH	泰国	Thailand	66
TJ	塔吉克斯坦	Tajikstan	992
TM	土库曼斯坦	Turkmenistan	993
TN	突尼斯	Tunisia	216
TO	汤加	Tonga	676
TR	土耳其	Turkey	90
TT	特立尼达和多巴哥	Trinidad and Tobago	1809
TW	台湾省	Taiwan	886
TZ	坦桑尼亚	Tanzania	255
UA	乌克兰	Ukraine	380
UG	乌干达	Uganda	256
US	美国	United States of America	1
UY	乌拉圭	Uruguay	598
UZ	乌兹别克斯坦	Uzbekistan	233
VC	圣文森特岛	Saint Vincent	1784
VE	委内瑞拉	Venezuela	58
VN	越南	Vietnam	84
YE	也门	Yemen	967
YU	南斯拉夫	Yugoslavia	381
ZA	南非	South Africa	27
ZM	赞比亚	Zambia	260
ZR	扎伊尔	Zaire	243
ZW	津巴布韦	Zimbabwe	263


 
	 */
}
