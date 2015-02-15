var passport = require('passport')
    , TwitterStrategy = require('passport-twitter').Strategy;
var Twitter = require('twitter');
var config = require('../../config/twitterconf');

passport.use('twitter-authz', new TwitterStrategy({
        consumerKey: config.consumerKey,
        consumerSecret: config.consumerSecret,
        callbackURL: config.callbackURL
    },
    function (token, tokenSecret, profile, done) {
		//console.log(profile);

        var account = {
            TWtoken: token,
            TWtokenSecret: tokenSecret,
            TwitterProfile : profile
        };
        done(null, account);

    }));

module.exports = function (app) {


	var tabListUsersTwitter = [];
	var tabListTwittByUser = [];

	/*var getUsersTwitt = function(listUsers,twitter){
		async.each(listUsers,
			function (userID,callback) {
				console.log(userID);
				twitter.get('/statuses/user_timeline', { count: 2, user_id: userID.toString() }, function(err, data,response) {
					console.log(data);
					if (err) {
						console.log(err);
					} else {
						tabListTwittByUser.push({userID: userID, userTwitt: data})
					}
					callback();
				});
				},
				function(err){
					//Finish second For each !
					console.log(tabListTwittByUser);
					return tabListTwittByUser;
				});
	};*/

	var recupUsers = function(data){
		//console.log(data);
		async.each(data,
			function (entry,callback) {
			//console.log(entry);
			tabListUsersTwitter.push(entry.id);
			callback();
		},
		function(err){
			//console.log(tabListUsersTwitter);
			return tabListUsersTwitter;
		});
	};

	//Passport --> Authenticate !!
    app.get('/oauth/twitter', passport.authorize('twitter-authz',{failureRedirect: 'http://pop.calopea.com:8080/pop.html#/contacts'}));

    // URL used in loginCallback above
    app.get('/twitter/callback',passport.authorize('twitter-authz', {failureRedirect: '/pop.html#/contacts'}),
        function (req, res) {
	        req.session.TwitterToken = req.account.TWtoken;
	        req.session.TwitterSecretToken = req.account.TWtokenSecret;
            res.redirect('/stimo.html#/home');
        });

    app.get('/stimo/importTwitter',function (req, res) {
        console.log(req.session);
        console.log("IMPORT TWITTER GENERAL");
		var nextCursor = -1;
		var myUserTwitt = {};
		console.log(req.session);

		var twitter = new Twitter({
		  consumer_key:config.consumerKey,
		  consumer_secret:config.consumerSecret,
		  access_token_key:req.session.TwitterToken,
		  access_token_secret:req.session.TwitterSecretToken
		});


		twitter.get(
		  '/statuses/user_timeline', { count: 100, user_id: '24513872' },
		function logResponse(error, data, response) {
		  if (error){
				res.send(error);
			}else {
				console.log(data);
				//recupUsers(data.users,twitter);
				res.status(200).json(data);
			}
		});

    });

};
