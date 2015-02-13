module.exports = function(app) {
    require('./Twitter/twitter')(app);
    //Default redirection to pop.html when "/" is called
    app.get('/', function(req, res) {
        res.redirect('/stimo.html')
    });
};
