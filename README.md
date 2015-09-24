# baiduSign
模拟百度登陆。
可以在此基础上实现每日签到等功能
本来是为了实现自动发贴的（为了作推广） 难度较高，没有攻下，只实现了登录了签到。

百度加密密码由js实现，试过.net 和JAVA的加密库，但结果不匹配。
因此把百度加密的js代码，提取了出来，布了个js的服务端

加密的的web服务，启动

/NODE/server/baidupassserver.js
/NODE/client 想实现nodejs的调用demo,但还未完成.

原先的登录逻辑是，从百度电脑端从浏览器逆向出来，比较复杂（算是核心代码）
现在更简单的登录方式，没有token,pubkey,加密pwd的步骤，直接传账号密码便可登录
路径为http://wappass.baidu.com/wp/login?uname_login=1

核心代码几本废了，不过因为是练习项目，倒无所谓。

