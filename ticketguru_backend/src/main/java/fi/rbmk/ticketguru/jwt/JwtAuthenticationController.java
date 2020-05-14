package fi.rbmk.ticketguru.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fi.rbmk.ticketguru.user.User;
import fi.rbmk.ticketguru.user.UserRepository;
import fi.rbmk.ticketguru.userGroup.UserGroup;
import fi.rbmk.ticketguru.userGroup.UserGroupRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://ticketguru-heroku.herokuapp.com/*"})
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserDetailServiceImpl userDetailService;
    @Autowired
    private UserRepository uRepository;
    @Autowired
    private UserGroupRepository uGRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;

    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        if (uRepository.findAll().isEmpty() && uGRepository.findAll().isEmpty()) {
            uRepository.save(new User(authenticationRequest.getUsername(), encoder.encode(authenticationRequest.getPassword()), uGRepository.save(new UserGroup("Admin"))));
        }
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
        throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
        throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}