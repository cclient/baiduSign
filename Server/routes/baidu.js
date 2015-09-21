var express = require('express');
var router = express.Router();
var baidusign=require('baidu-pwd-sign');

/* GET home page. */
router.post('/signpwd', function(req, res, next) {
    console.log(req.body);
    var signres= baidusign.signpwd(req.body.publickey,req.body.password)
    console.log(signres);
    res.send(signres);
});

module.exports = router;
