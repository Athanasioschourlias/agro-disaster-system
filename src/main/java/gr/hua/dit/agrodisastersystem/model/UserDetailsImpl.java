package gr.hua.dit.agrodisastersystem.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {


    @Serial
    private static final long serialVersionUID = 1L;

    private final User user;

    public UserDetailsImpl(User user) {
        super();
        this.user=user;


    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {


        List<GrantedAuthority> grantedAuthorities=new ArrayList<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+this.user.getRole().toUpperCase()));
//		System.out.println("inside details impl "+grantedAuthorities.get(0).getAuthority());
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getIt();
    }


    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    @Override
    public boolean isAccountNonLocked() {

        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {

        return true;
    }

    @Override
    public boolean isEnabled() {

        return true;
    }

    public User getUserDetails() {
        return user;
    }

    public String hasRole(){
        return this.user.getRole();
    }
}