package auth.ctrl;

import auth.ctrl.doc.AuthCtrlDoc;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthCtrl implements AuthCtrlDoc {
}
