'use strict';

var passport=require('./passport');
var baidu=require('./baidu').baidu;
function signpwd(publickey,password){
    var RSA = new passport.lib.RSA();
    RSA.setKey(publickey);
    return baidu.url.escapeSymbol(RSA.encrypt(password));
}
module.exports = {
    signpwd: signpwd
};
