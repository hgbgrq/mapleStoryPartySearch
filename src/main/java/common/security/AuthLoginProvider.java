package common.security;

import common.security.dto.LoginUserInfoDto;
import common.security.svc.SecuritySvc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class AuthLoginProvider implements AuthenticationProvider {

    @Autowired
    private SecuritySvc securitySvc;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userId = authentication.getName();
        String passWord = authentication.getCredentials().toString();
        UsernamePasswordAuthenticationToken result = null;

        String dbPassWord = securitySvc.getDbPassWord(userId);
        if(dbPassWord == null || !passWord.equals(dbPassWord)){
            log.error("로그인 실패");
            return null;
        }

        log.info("로그인 성공");
        LoginUserInfoDto loginUserInfoDto  = securitySvc.getUserInfo(userId);
        List<String> authList = securitySvc.getAuthList(userId);
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        for(String auth : authList){
            grantedAuthorityList.add(new SimpleGrantedAuthority(auth));
        }
        result = new UsernamePasswordAuthenticationToken(loginUserInfoDto, passWord, grantedAuthorityList);

        return result;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
