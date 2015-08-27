/**
 * Created by MI177 on 2014/10/15.
 */

var baidu = baidu || {};
baidu.url = baidu.url || {};
baidu.url.escapeSymbol = baidu.url.escapeSymbol || function(source) {
    return String(source).replace(/[#%&+=\/\\\ \　\f\r\n\t]/g, function(all) {
        return "%" + (256 + all.charCodeAt()).toString(16).substring(1).toUpperCase()
    })
};

exports.baidu =baidu;