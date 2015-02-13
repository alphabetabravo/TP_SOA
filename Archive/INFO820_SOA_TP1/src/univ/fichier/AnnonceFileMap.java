/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package univ.fichier;
public class AnnonceFileMap {

    private String createAt;
    private String text;
    private String source;
    private User user;

    public String getSource() {
        return source;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreateAt() {
        return createAt;
    }

    public String getText() {
        return text;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public class User {

        private int id;
        private String name;
        private String location;
        private String description;

        public int getid() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setid(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getLocation() {
            return location;
        }

        public String getDescription() {
            return description;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public void setDescription(String description) {
            this.description = description;
        }

    }
}
