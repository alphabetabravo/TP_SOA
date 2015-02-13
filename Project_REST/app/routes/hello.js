
module.exports = function(app) {
    //--- CRUD --------------------------------	---------------------------
    // get Hello
    app.get('/hello',function(req, res) {
        res.status(200).send('Hello NodeJS 2015')
    });
};