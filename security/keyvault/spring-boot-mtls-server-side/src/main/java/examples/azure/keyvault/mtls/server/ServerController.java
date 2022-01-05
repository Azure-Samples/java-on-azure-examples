package examples.azure.keyvault.mtls.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello mTLS";
    }
}
