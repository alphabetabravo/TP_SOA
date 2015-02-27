module.exports = function (app) {
		var http = require('http');
		var soap = require('soap');
		var helloService = {
		  Hello_Service: {
		    Hello_Port: {
		      sayHello: function(args) {
		        return {
		          greeting: "Hello!!!"
		        };
		      }
		    }
		  }
		};
		var xml = require('fs').readFileSync('HelloService.wsdl', 'utf8'),
		      server = http.createServer(function(request,response) {
		          response.end("404: Not Found: "+request.url)
		      });
      console.log("OKKKKKKKKKKKKKKKKKKKKKKKKKkkk");
		server.listen(1234);
		console.log("Server is listening");
		console.log(server);
		console.log(helloService);
		console.log(xml);
		soap.listen(server, '/wsdl', helloService, xml);
		console.log(soap.WSDL.toString());
		console.log("kjezfpiuÙUFHZEPIFUHPHFpYFHJDZMFGHPMUjhfIKHMOUfhmLGFIUdpfiUFMGZfhbZEUIFJMIZjfùZHF!LfhùMOZSDFBLZJfm:KJZFM:KHjfm:jBNÙFKLHMOIGKJUZE")
};
