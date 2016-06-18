package grails.plugin.springsecurity.oauth2.google

import com.github.scribejava.apis.GoogleApi20
import com.github.scribejava.core.builder.api.DefaultApi20
import com.github.scribejava.core.model.OAuth2AccessToken
import grails.converters.JSON
import grails.plugin.springsecurity.oauth2.exception.OAuth2Exception
import grails.plugin.springsecurity.oauth2.service.OAuth2AbstractProviderService
import grails.plugin.springsecurity.oauth2.token.OAuth2SpringToken
import grails.transaction.Transactional

@Transactional
class OAuth2GoogleService extends OAuth2AbstractProviderService {

    @Override
    String getProviderID() {
        return 'google'
    }

    @Override
    Class<? extends DefaultApi20> getApiClass() {
        return GoogleApi20.class
    }

    @Override
    String getProfileScope() {
        return 'https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo.email'
    }

    @Override
    OAuth2SpringToken createSpringAuthToken(OAuth2AccessToken accessToken) {
        def user
        def response = getResponse(accessToken)
        try {
            log.debug("JSON response body: " + accessToken.rawResponse)
            user = JSON.parse(response.body)
        } catch (Exception exception) {
            log.error("Error parsing response from " + getProviderID() + ". Response:\n" + response.body)
            throw new OAuth2Exception("Error parsing response from " + getProviderID(), exception)
        }
        if (!user?.email) {
            log.error("No user email from " + getProviderID() + ". Response was:\n" + response.body)
            throw new OAuth2Exception("No user id from " + getProviderID())
        }
        return new GoogleOauth2SpringToken(accessToken, user?.email)
    }
}
