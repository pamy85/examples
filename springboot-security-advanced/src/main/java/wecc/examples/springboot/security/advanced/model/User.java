package wecc.examples.springboot.security.advanced.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class User {

    @Id
    private String user;
    private String password;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<GrantedAuthority> roles;

    public User() {
    }

    public User(String user, String password, List<GrantedAuthority> roles) {
        this.user = user;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.roles = roles;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(List<GrantedAuthority> roles) {
        this.roles = roles;
    }

}
