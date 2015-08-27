# baiduSign
破解百度登陆。
可以在此基础上实现每日签到等功能
本来是为了实现自动发贴的…… 难度较高，没有攻下，只实现了登录了签到。
签到的代码丢了，进百度的个人主页，试几次，找到答到的API，传参，request即可

百度加密密码由js实现，试过.net 和JAVA的加密库，但结果不匹配。
因此把百度加密的js代码，提取了出来，布了个js的服务端

加密的的web服务，启动

/NODE/server/baidupassserver.js
/NODE/client 想实现nodejs的调用demo,但还未完成.
/JBaiduPost  java实现的demo 非mvn项目，eclipse打开，比较旧。
/.net 丢了，签到就是这在实现在的，我找找看。
/android 我找找看…… 部分细节和java的不同
