package org.jb.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.jb.dto.LoginDto;
import org.jb.dto.LoginResponseDto;
import org.jb.entity.Login;
import org.jb.entity.Menu;
import org.jb.entity.Role;
import org.jb.entity.User;
import org.jb.repository.LoginRepository;

import java.time.LocalDateTime;

@ApplicationScoped
@Slf4j
public class LoginService {

    @Inject
    private UserService userService;

    @Inject
    private RoleService roleService;

    @Inject
    private LoginRepository loginRepository;

    @Transactional
    public LoginResponseDto getLoginInfo(LoginDto loginDto) {
        User user = userService.findByUsernameAndPassword(loginDto.getUserName(), loginDto.getPassword());
        if (user != null) {
            try {

                // Get User Info
                LoginResponseDto responseDto = new LoginResponseDto();
                Role role = roleService.findByRoleId(user.getRoleId());
                responseDto.setUserName(user.getUserName());
                responseDto.setPassword(user.getPassword());
                responseDto.setRole(role);
                responseDto.setUserId(user.getUserId());

                // Save login info
                Login login = Login.builder()
                        .loginDateTime(LocalDateTime.now().toString())
                        .active(1)
                        .userId(user.getUserId())
                        .build();

                loginRepository.saveLogin(login);

                return responseDto;
            } catch (Exception e) {
                log.error(e.getLocalizedMessage());
            }

        }
        return null;
    }

    public String logOut(Long userId) {
        User user = userService.findByUserId(userId);
        if (user != null) {
            Login login = Login.builder()
                    .logoutDateTime(LocalDateTime.now().toString())
                    .userId(user.getUserId())
                    .build();

            loginRepository.updateLogin(user.getUserId(), login);
            return "Log Out Successfully";
        } else {
            return "Log Out Fail!";
        }

    }
}
