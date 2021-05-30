package pl.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.project.user.UserRepository;

@Component
public class DbInit implements InitializingBean {
    private final static Logger LOGGER = LoggerFactory.getLogger(DbInit.class);

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void afterPropertiesSet(){
        LOGGER.info("Kod wykonywany po inicjalizacji beana");
    }
}
