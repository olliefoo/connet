package main;

import java.io.Serializable;
/**
 * Created by cbbjs on 11/12/2016.
 */
public class User implements Serializable{
        private String username;
        private String password;
        private int currentConventionNum;
        private Profile profile;
        private String email;

        public User(String username, String password, int currentConventionNum, String email) {
            this.username = username;
            this.password = password;
            profile = new Profile();
            this.currentConventionNum = currentConventionNum;
            this.email = email;
            profile.setEmail(email);
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public Profile getProfile() { return profile; }

        public void setEmail(String s) {
            email = s;
        }

        public boolean setPassword(String p) {
            if (password.equals(p)) {
                return false;
            }
            password = p;
            return true;
        }
    }
}
