var soap = require('soap');
var url = 'http://www.webservicex.net/mortgage.asmx?WSDL';
var urlLocal = 'HelloService.wsdl';


module.exports = function (app) {

	// URL used in loginCallback above
	app.post('/HelloService',function (req, res) {res.send("OkSoaP")});

	app.put('/mortgage',
		function (req, res) {
			console.log(req.body);
			var args = {
				Years: req.body.Years,
				Interest: req.body.Interest,
				LoanAmount: req.body.LoanAmount,
				AnnualTax: req.body.AnnualTax,
				AnnualInsurance: req.body.AnnualInsurance
			};
			soap.createClient(url, function (err, client) {
				client.GetMortgagePayment(args, function (err, result) {
					console.log("Result SOPA");
					console.log(result);
					res.status(200).send(result);
				});
			});
		});


	// URL used for sort value about twitter result
	app.get('/sort/:type_sort',
		function (req, res) {
			//console.log(req.body);
			/*var args = {
				myArg1: 10,
				myArg2: 15
			};*/
			var args = {
				tickerSymbol: "Test"
			};
			soap.createClient(urlLocal, function (err, client) {
				//console.log(client);
				//console.log(err);
				client.GetLastTradePrice(args, function (err, result) {
					console.log("Result SOAP LOCAL");
					//console.log(err);
					console.log(result);
					//res.status(200);
				});
			});
		});

	// URL used for sort value about twitter result
	app.get('/googleEngine',
		function (req, res) {
			//console.log(req.body);
			console.log("OK appel REST");

			var gcloud = require('gcloud')({
			  projectId: '890764983394',
			  //projectId: '890764983394-4poqvqhttjav6m8913eja06gla203n0c.apps.googleusercontent.com',
			  keyFilename: 'td3info820remifrancois-5e97e1173bbf.json'
				//credentials: require('td3info820remifrancois-5e97e1173bbf.json')
			});
			var dataset = gcloud.datastore.dataset();

			//dataset.get(dataset.key(['Product', 'Computer']), function(err, entity) {
			//  console.log(err || entity);
			//});

			// Save data to your dataset.
			var blogPostData = {
			  title: 'How to make the perfect homemade pasta',
			  tags: ['pasta', 'homemade'],
			  author: 'Andrew Chilton',
			  isDraft: true,
			  wordCount: 450
			};

			var blogPostKey = dataset.key('BlogPost');

			dataset.save({
			  key: blogPostKey,
			  data: blogPostData
			}, function(err) {
			  // `blogPostKey` has been updated with an id so you
			  // can do more operations with it. Such as an update:
			  console.log(err);
			  dataset.save({
			    key: blogPostKey,
			    data: {
			      isDraft: false
			    }
			  }, function(err) {
			    //console.log(err);
			  });
			});


			/*ds.save({
			  key: ds.key(['Company']),
			  data: {
			    'name': 'tacos'
			  }
			}, function(err) {
			  if (err) {
			    console.log(err);
			    return;
			  }
			  res.send('Hello, world from ' + err);
			});*/

			// Or from elsewhere:
			/*dataset = gcloud.datastore.dataset({
			  projectId: '890764983394',
			  keyFilename: 'td3info820remifrancois-5e97e1173bbf.json'

			});
			key = dataset.key({
				namespace: 'Info820'
			  path: ['Company', 123]
			});
			console.log(key);
			dataset.get(key, function(err, entity) {
		        console.log(err || entity);
		    });*/


			/*var keystore = require('gcloud-keystore')(dataset);
			keystore.set('todos', ['eat', 'sleep', 'repeat'], function(err, key) {
				console.log(err);
				console.log(key);
			});
			keystore.get('todos', function(err, todos) {
				console.log(todos);
				console.log(err);
			  // todos:
			  //   ['eat', 'sleep', 'repeat']
			});*/
			/*console.log(dataset);
			dataset.get(dataset.key(['Product', 'Computer']), function(err, entity) {
			  console.log(err || entity);
			});*/
		});
};