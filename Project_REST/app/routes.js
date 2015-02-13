module.exports = function(app) {
    require('./routes/hello.js')(app);
	app.get('/', function(req, res) {
        res.redirect('/home')
    });
};