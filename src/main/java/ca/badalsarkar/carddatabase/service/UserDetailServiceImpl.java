package ca.badalsarkar.carddatabase.service;

import ca.badalsarkar.carddatabase.model.Users;
import ca.badalsarkar.carddatabase.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// The interface UserDetailsService provides functionality
// for user authentication and authorization

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    // This method pack users details into one object which is used for authentication
    // and authorization
    // first it find the user in the database and then provides necessary information
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users currentUser = userRepository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, currentUser.getPassword(),
                true,true,true,true,
                AuthorityUtils.createAuthorityList(currentUser.getRole()));
        return user;
    }
}
