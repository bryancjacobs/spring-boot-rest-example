package app.config;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

/**
 * User: Bryan
 * Date: 3/17/14
 * Time: 8:38 PM
 */
@Configuration
public class TomcatHttpsConfig {
    @Bean
    @Autowired
    public EmbeddedServletContainerCustomizer containerCustomizer(@Value("${keystore.file}") final String keystoreFile,
                                                                  @Value("${keystore.password}") final String keystorePassword,
                                                                  @Value("${keystore.type}") final String keystoreType,
                                                                  @Value("${keystore.alias}") final String keystoreAlias) throws FileNotFoundException
    {
        final String absoluteKeystoreFile = ResourceUtils.getFile(keystoreFile).getAbsolutePath();

        return container -> {
            TomcatEmbeddedServletContainerFactory factory = (TomcatEmbeddedServletContainerFactory)container;
            factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
                @Override
                public void customize(Connector connector) {
                    connector.setSecure(true);
                    connector.setScheme("https");
                    connector.setAttribute("keystoreFile", absoluteKeystoreFile);
                    connector.setAttribute("keystorePass", keystorePassword);
                    connector.setAttribute("keystoreType", keystoreType);
                    connector.setAttribute("keyAlias", keystoreAlias);
                    connector.setAttribute("clientAuth", "false");
                    connector.setAttribute("sslProtocol", "TLS");
                    connector.setAttribute("SSLEnabled", true);
                }
            });


        };
    }
}
