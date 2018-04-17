package pl.mal.trakmind.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
@EnableAuthorizationServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
class OAuth2Configuration extends AuthorizationServerConfigurerAdapter {

    private final AuthenticationManagerBuilder authenticationManager;

    public OAuth2Configuration(AuthenticationManagerBuilder authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.authenticationManager(authentication -> authenticationManager
                .getOrBuild().authenticate(authentication));
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        String applicationName = "trakmind";
        clients.inMemory()
                .withClient("web-" + applicationName)
                .authorizedGrantTypes("password", "authorization_code", "refresh_token")
                .authorities("ROLE_USER")
                .scopes("write")
                .resourceIds(applicationName)
                .secret("{noop}123456");
    }
}

@Configuration
class ResourceServer extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId("trakmind");
    }

}