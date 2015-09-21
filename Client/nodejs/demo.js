/**
 * Created by cdpmac on 15/8/6.
 */

var tool = require('./tool');
var request = require('request');
var async = require('async');
//function getToken(callback){
//    var dt=new Date();
//    var timenum=dt.getTime();
//    var j = request.jar()
//    request = request.defaults({jar:j})
//    async.waterfall([
//        function(callback){
//            request(
//                { method: 'GET'
//                    , uri: "http://passport.baidu.com/v2/api/?getapi&tpl=tb&apiver=v3&tt=" + timenum + "&class=login&logintype=dialogLogin"
//                    , gzip: true
//                }
//                , function (error, response, body) {
//                    callback(null);
//                }
//            )
//        },
//        function(callback){
//            request(
//                { method: 'GET'
//                    , uri: "http://passport.baidu.com/v2/api/?getapi&tpl=tb&apiver=v3&tt=" + timenum + "&class=login&logintype=dialogLogin"
//                    , gzip: true
//                }
//                , function (error, response, body) {
//                    callback(null,body);
//                }
//            )
//        },
//        function(tokenstring, callback){
//            var tokenobj=JSON.parse(tokenstring.replace(/'/g,"\""));
//            callback(null, tokenobj);
//        }
//    ], function (err, tokenobj) {
//        console.log(err);
//        console.log(tokenobj);
//        callback(err?"":tokenobj.data.token,j);
//    });
//}
//function getPublicKey(token,baiducookie,callback){
//    console.log(token);
//    request(
//        { method: 'GET'
//            , uri: "http://passport.baidu.com/v2/api/?getapi&tpl=tb&apiver=v3&tt=" + timenum + "&class=login&logintype=dialogLogin"
//            , gzip: true
//        }
//        , function (error, response, body) {
//            body="abc";
//            callback(body,baiducookie);
//        }
//    )
//}
//
//function getpassword(publickey,baiducookie,callback){
//    request(
//        { method: 'POST'
//            , uri: "http://localhost:3000"
//            , gzip: true
//        }
//        , function (error, response, body) {
//            body="abc";
//            callback(body,baiducookie);
//        }
//    )
//}

//request.post({url:"http://localhost:3000", formData:{publickey:"1234",password:"2222"}}, function (e, r, body) {
//    console.log(body);
//    // ready to make signed requests on behalf of the user
//})

request.post({url:"http://localhost:3000",form:{publickey:"1234",password:"2222"}}, function (e, r, body) {
    console.log(body);
    // ready to make signed requests on behalf of the user
})