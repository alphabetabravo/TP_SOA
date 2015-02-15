var soap = require('soap');
var url = 'http://www.webservicex.net/mortgage.asmx?WSDL';
module.exports = function (app) {

	// URL used in loginCallback above
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
};