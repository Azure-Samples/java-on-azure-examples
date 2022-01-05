package examples.azure.keyvault.mtls.client;

import java.io.IOException;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.PrivateKeyDetails;
import org.apache.http.ssl.PrivateKeyStrategy;
import org.apache.http.ssl.SSLContexts;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * This REST controller shows you how you would initiate an HTTP call using a
 * REST template with a client-side certificate to an external server.
 * 
 * @author Manfred Riem (manfred.riem@microsoft.com)
 */
@RestController
public class ClientController {

    /**
     * This PrivateKeyStrategy determines which certificate to send back to the
     * server. In this particular case the certificate with the 'self-signed'
     * alias is used.
     */
    private class ClientPrivateKeyStrategy implements PrivateKeyStrategy {

        /**
         * Choose which alias to use for the client certificate.
         *
         * @param aliases the aliases.
         * @param socket the socket.
         * @return the alias to use.
         */
        @Override
        public String chooseAlias(Map<String, PrivateKeyDetails> map, Socket socket) {
            return "self-signed";
        }
    }

    /**
     * Create the REST template.
     *
     * @return the REST template, or null if it failed.
     */
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = null;
        try {
            KeyStore ks = getKeyStore();

            SSLContext sslContext = SSLContexts.custom()
                    .loadKeyMaterial(ks, "".toCharArray(), new ClientPrivateKeyStrategy())
                    .loadTrustMaterial(ks, new TrustSelfSignedStrategy())
                    .build();

            HostnameVerifier allowAll = (String hostName, SSLSession session) -> true;
            SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext, allowAll);

            CloseableHttpClient httpClient = HttpClients.custom()
                    .setSSLSocketFactory(csf)
                    .build();

            HttpComponentsClientHttpRequestFactory requestFactory
                    = new HttpComponentsClientHttpRequestFactory();

            requestFactory.setHttpClient(httpClient);
            restTemplate = new RestTemplate(requestFactory);

        } catch (NoSuchAlgorithmException | KeyStoreException | UnrecoverableKeyException
                | KeyManagementException e) {
            e.printStackTrace();
        }
        
        return restTemplate;
    }

    /**
     * Get the default AzureKeyVault KeyStore.
     * 
     * <p>
     *  If you want to be able to use multiple KeyVaults use a 
     *  KeyVaultLoadStoreParameter instead of passing null into the load method.
     * </p>
     *
     * @return the KeyStore, or null if initialization failed.
     */
    private KeyStore getKeyStore() {
        KeyStore ks = null;

        try {
            ks = KeyStore.getInstance("AzureKeyVault");
            ks.load(null, "".toCharArray());
        } catch (KeyStoreException | IOException | NoSuchAlgorithmException
                | CertificateException e) {
            e.printStackTrace();
        }
        return ks;
    }

    /**
     * Call the external server that requires a client-certificate.
     * 
     * @return 'Hello mTLS' or 'Oops' when the call failed.
     */
    @RequestMapping("/hello")
    public String hello() {
        try {
            return restTemplate().getForObject("https://localhost:8081/hello", String.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "Oops";
    }
}
