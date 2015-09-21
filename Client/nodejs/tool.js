/**
 * Created by cdpmac on 15/8/6.
 */

//var http= require('http');
var request = require('request');

//var touchcookie =require('tough-cookie');

//这个方法不支持cookies放弃
//function accessWebAPI(host,path,method,data,callback){
//    var queryoptions = {
//        host: host,
//        path: path,
//        method: method,
//        headers: {
//            "Content-Type": 'application/json'
//        }
//    };
//    var senddata='';
//    var req = http.request(queryoptions, function(res) {
//        res.setEncoding('utf8');
//        res.on('data', function (chunk) {
//            senddata+=chunk;
//        });
//        res.on('end', function() {
//            console.log('host '+host+path);
//            senddata=senddata.replace(/'/g,"\"");
//            callback(null,JSON.parse(senddata));
//        });
//    });
//    if(data){
//        var data=JSON.stringify(data);
//        req.write(data+'\n');
//    }
//    else{
//        req.write(''+'\n');
//    }
//    req.on('error', function(e) {
//        console.log('api error'+e);
//        callback(e,null);
//    });
//    req.end();
//}

function test(){

    var j = request.jar()
    request = request.defaults({jar:j})
    request(
        { method: 'GET'
            , uri: 'http://passport.baidu.com/v2/api/?getapi&tpl=tb&apiver=v3&tt=1438847515520&class=login&logintype=dialogLogin'
            , gzip: true
//            ,jar:true
        }
        , function (error, response, body) {
            console.log('server encoded the data as: ' + (response.headers['content-encoding'] || 'identity'))
            console.log('the decoded data is: ' + body)
            console.log(j);
        }
    )

//        .on('data', function(data) {
//            console.log('decoded chunk: ' + data)
//        })
//        .on('response', function(response) {
//            // unmodified http.IncomingMessage object
//            response.on('data', function(data) {
//                // compressed data as it is received
//                console.log('received ' + data.length + ' bytes of compressed data')
//            })
//        })

}
//test();
//exports.accessWebAPI= accessWebAPI;
