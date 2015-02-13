/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package univ.controller;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import twitter4j.JSONException;
import twitter4j.JSONObject;
import twitter4j.Status;
import twitter4j.Twitter;
import univ.fichier.AnnonceFileMap;
import univ.fichier.AnnonceFileMap.User;

/**
 *
 * @author Emmanuel1
 */
public class TraitementJSON {

    public static void ajouter() throws JSONException, IOException {
        ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
        User user = mapper.readValue(new File("user.json"), User.class);
    }

    public static void javaToJson(Status twitter) {

        ObjectMapper mapper = new ObjectMapper();

        try {

            // convert user object to json string, and save to a file
            mapper.writeValue(new File("user.json"), twitter);

            // display to console
            System.out.println(mapper.writeValueAsString(twitter));

        } catch (JsonGenerationException e) {

            e.printStackTrace();

        } catch (JsonMappingException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}
