/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authentification;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class Authentification {

    

    public Twitter connecteMoiATwitter(
            String consumerKeyStr, String consumerSecretStr,
            String accessTokenStr, String accessTokenSecretStr) {
        try {
            Twitter twitter = new TwitterFactory().getSingleton();
            twitter.setOAuthConsumer(consumerKeyStr, consumerSecretStr);
            AccessToken accessToken = new AccessToken(accessTokenStr,
                    accessTokenSecretStr);
            twitter.setOAuthAccessToken(accessToken);
            return twitter;
        } catch (Exception e) {
            System.out.println("Erreur connection à l'API de twitter");
            e.printStackTrace();
        }
        return null;
    }
}
