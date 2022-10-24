package common.security.svc.Impl;

import common.security.dto.LoginUserInfoDto;
import common.security.svc.SecuritySvc;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class securityImpl implements SecuritySvc {

    @Override
    public String getDbPassWord(String userId) {
        return null;
    }

    @Override
    public LoginUserInfoDto getUserInfo(String userId) {
        return null;
    }

    @Override
    public List<String> getAuthList(String userId) {
        return null;
    }
}
