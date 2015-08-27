/**
 * Created by Administrator on 14-5-11.
 */

var http=require('http');
var url=require('url');
var util=require('util');
var Passport=require('./passport');
var  passport=new Passport();
var baidu=require('./baidu').baidu;
var querystring = require("querystring");
http.createServer(function(req,res){
    res.writeHead(200,{'Content-Type':'text/html'});
    req.setEncoding('utf-8');
    var postData = ""; //POST & GET ： name=zzl&email=zzl@sina.com
    // 数据块接收中
    req.addListener("data", function (postDataChunk) {
        postData += postDataChunk;
    });
    // 数据接收完毕，执行回调函数
    req.addListener("end", function () {
        console.log(postData);
        var params = querystring.parse(postData);//GET & POST  ////解释表单数据部分{name="zzl",email="zzl@sina.com"}
        console.log(params);
         var RSA = new passport.lib.RSA();
        RSA.setKey(params["publickey"]);
        var endpass1=baidu.url.escapeSymbol(RSA.encrypt(params["password"]));
//        console.log(params["publickey"]);
//        console.log(params["password"]);
//        console.log(endpass1);
        res.end(endpass1);
    });
}).listen(3000);
console.log("Http Server is Listening at port 3000.");
