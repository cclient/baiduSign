var express = require('express');
var router = express.Router();
var fs= require('fs');

/* GET users listing. */

router.get('/version', function(req, res, next) {
    return res.json({ item: {version:"1.0.1"} });
});
//不支持断点续传
router.get('/download/:filename', function(req, res, next) {
    var filename=req.params.filename;
    var filePath='../downloadfile/'+filename;
    fs.exists(filePath, function(exists){
        if ( !exists ) {
            res.writeHead(404, {'Content-Type': 'text/plain'});
            res.end();
        } else {
            console.log(filePath);
            fs.readFile(filePath, 'binary', function(err, file){
                console.log(file);
                if ( err ) {
                    res.writeHead(500, {'Content-Type': 'text/plain'});
                    res.end();
                } else {
                    res.setHeader('Content-Type', 'application/vnd.openxmlformats');
                    res.setHeader("Content-Disposition", "attachment; filename=" + filename);
                    res.setHeader('Content-Length', file.length);
                    res.write(file, 'binary');
                    res.end();
                }
            });
        }
    })
});
module.exports = router;
