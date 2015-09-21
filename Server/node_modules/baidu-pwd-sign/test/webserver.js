'use strict';


var http=require('http');
var baidusing=require('../index');
var querystring = require("querystring");
http.createServer(function(req,res){
    res.writeHead(200,{'Content-Type':'text/html'});
    req.setEncoding('utf-8');
    var postData = "";
    // 数据块接收中
    req.addListener("data", function (postDataChunk) {
        postData += postDataChunk;
    });
    // 数据接收完毕，执行回调函数
    req.addListener("end", function () {
        console.log(postData);
        var params = querystring.parse(postData);//GET & POST  ////解释表单数据部分{name="zzl",email="zzl@sina.com"}
        console.log(params);
        var result=baidusing.signpwd(params["publickey"],params["password"]);
        res.end(result);
    });
}).listen(3000);
console.log("start at"+3000);

