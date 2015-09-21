var express = require('express');
var paginationHelper=require("../util/pagination");
var router = express.Router();

var CONST = require('../util/const');


/* GET users listing. */
router.get('/', function(req, res, next) {
    var pagination = paginationHelper.getFromReq(req.query, CONST.ROUTER_DEFAULT_LIMIT);
//    redisManager.getRouterInfosList(pagination.offset, pagination.offset + pagination.limit, function (error, routerInfos, sum)
//    {
//        res.json({
//            meta: paginationHelper.getMeta(sum, routerInfos.length, pagination),
//            list: routerInfos
//        });
//    });
});

module.exports = router;
