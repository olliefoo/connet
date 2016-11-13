package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
//import main.Database;
import main.Profile;
import main.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Owner on 11/12/2016.
 */
public class FindMatchController {

    @FXML
    TextField nameField;

    @FXML
    Button findMatchButton;

    @FXML
    ImageView matchedImage;

    User user;

    public void setUser(User user) {
        this.user = user;
    }


    /*@FXML
    private void displayMatch() {
        User matchedUser = findMatch();
        Profile matchedProfile = matchedUser.getProfile();
        nameField.setText(matchedProfile.getFirstname() + " " + matchedProfile.getLastname());
        matchedImage.setImage(matchedProfile.getProfilePic());
    }*/

    /*private User findMatch() {
        // loop through all the users and check if they are in the same convention
        List<User> sameConvention = new ArrayList<>(10);
        for(User u : Database.getUsers()) {
            if(user.getConvention() == u.getConvention()) {
                sameConvention.add(u);
            }
        }
        // now have to check each user's preference to see if match
        Set userPreferences = user.getPreferences();
        Set temp = userPreferences;
        int min = 100;
        User matchedUser = null;
        for(User u : sameConvention) {
            temp.removeAll(u.getPreferences());
            // if is perfect match then return
            if(temp.size() == 0) {
                user.setMatchedUser(u);
                return u;
            } else if(temp.size() < min) {
                min = temp.size();
                matchedUser = u;
            }
            temp = userPreferences;
        }
        user.setMatchedUser(matchedUser);
        return matchedUser;
    }*/

}
