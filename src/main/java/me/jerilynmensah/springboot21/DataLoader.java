package me.jerilynmensah.springboot21;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String...strings) throws Exception{
        System.out.println("Loading Data...");

        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));

        Role adminRole = roleRepository.findByRole("ADMIN");
        Role userole = roleRepository.findByRole("USER");

        User user = new
                User("bob@bob.com", "bob","Bob","Bobberson", true, "bob");
        user.setRoles(Arrays.atList(userRole));
        userRepository.save(user);

        user = new
                User("jim@jim.com", "jim","Jim","Jimmerson", true, "jim");
        user.setRoles(Arrays.atList(userRole));
        userRepository.save(user);

        user = new
                User("admin@adm.com", "pass","Admin","User", true, "admin");
        user.setRoles(Arrays.atList(adminRole));
        userRepository.save(user);


        user = new
                User("sam@ev.com", "pass","Sam","Everyman", true, "sam");
        user.setRoles(Arrays.atList(userRole, adminRole));
        userRepository.save(user);

    }
}
