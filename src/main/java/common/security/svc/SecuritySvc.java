package common.security.svc;

import common.security.dto.LoginUserInfoDto;

import java.util.List;

public interface SecuritySvc {

    String getDbPassWord(String userId);

    LoginUserInfoDto getUserInfo(String userId);

    List<String> getAuthList(String userId);
}
