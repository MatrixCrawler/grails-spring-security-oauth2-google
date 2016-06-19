package grails.plugin.springsecurity.oauth2.google

import com.github.scribejava.core.model.OAuth2AccessToken
import grails.plugin.springsecurity.oauth2.token.OAuth2SpringToken

/**
 * Always code as if the guy who ends up maintaining your code
 * will be a violent psychopath that knows where you live.
 *
 * - John Woods
 *
 * Created on 18.06.2016
 * @author MatrixCrawler
 */
class GoogleOauth2SpringToken  extends OAuth2SpringToken{

    GoogleOAuth2Service oAuth2GoogleService
    private String email

    GoogleOauth2SpringToken(OAuth2AccessToken accessToken, String email) {
        super(accessToken)
        this.email = email
    }

    @Override
    String getProviderName() {
        return oAuth2GoogleService.providerID
    }

    @Override
    String getSocialId() {
        return email
    }

    @Override
    String getScreenName() {
        return email
    }
}
