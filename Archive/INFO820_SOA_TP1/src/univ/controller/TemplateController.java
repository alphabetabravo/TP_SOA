/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package univ.controller;

import authentification.Authentification;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import net.webservicex.Mortgage;
import net.webservicex.MortgageResults;
import net.webservicex.MortgageSoap;
import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 *
 * @author yirou
 */
public class TemplateController {

    Authentification auth;
    Twitter twitter;

    public TemplateController() {
    }

    public double calculPret(double montant, String frequence, int annee) throws MalformedURLException {
        QName SERVICE_NAME = new QName("http://www.webserviceX.NET/", "Mortgage");
        URL wsdlURL = new URL("http://www.webservicex.net/mortgage.asmx?WSDL");

        Mortgage ss = new Mortgage(wsdlURL, SERVICE_NAME);
        MortgageSoap port = ss.getMortgageSoap();

        int _getMortgagePayment_years = annee;
        double _getMortgagePayment_interest = 0.05;
        double _getMortgagePayment_loanAmount = montant;
        double _getMortgagePayment_annualTax = 0.9;
        double _getMortgagePayment_annualInsurance = 0.82;

        MortgageResults _getMortgagePayment__return = port.getMortgagePayment(_getMortgagePayment_years, _getMortgagePayment_interest, _getMortgagePayment_loanAmount, _getMortgagePayment_annualTax, _getMortgagePayment_annualInsurance);

        //System.out.println("getMortgagePayment.result=" + _getMortgagePayment__return.getTotalPayment());
        return _getMortgagePayment__return.getTotalPayment();
    }

    public ArrayList<Status> getListeAnnonceImmobilier(int max,int surface) throws TwitterException {
        ArrayList<Status> listeTweet;
        if (auth == null) {
/*            String consumerKeyStr = "9l72yrvVlUV4gS9Uk92wHbsrV";
            String consumerSecretStr = "kGR1Q8qoDuEnmAolDeV6S5WlmOwvT1GqbNxRIi6WZqRH6crMUk";
            String accessTokenStr = "1160048413-rvche69Zxh6r4N6AZf2PkhuAO2BHUS91R13xzQ4";
            String accessTokenSecretStr = "v45uSdSAA19FZewFqe8UE1JZzoc1UuhxdROrcySMoTfS4";*/
            auth = new Authentification();
//            twitter = auth.connecteMoiATwitter(consumerKeyStr, consumerSecretStr, accessTokenStr, accessTokenSecretStr);
        }
        listeTweet = lancerLaRequette(max,surface);
        return listeTweet;
    }

    public ArrayList<Status> lancerLaRequette(int max,int surface) throws TwitterException {

//        Query query = new Query("#annonce #vente maison");
//        query.setCount(max);
//        QueryResult result = twitter.search(query);
//
//        ArrayList<Status> tweets = (ArrayList<Status>) result.getTweets();
//        return tweets;
        
        Paging paging = new Paging(1, 1);
        ArrayList<Status> tweets = (ArrayList)twitter.getUserTimeline("Immogo", paging);
        return tweets;
//        for(Status status:statuses){
//            System.out.println(status);
//        }
    }
    
    public void afficherLeResultat(ArrayList<Status> tweets){
        for (Status tweet : tweets) {
                System.out.println("Tweet: " + tweet);
            }
    }
}
