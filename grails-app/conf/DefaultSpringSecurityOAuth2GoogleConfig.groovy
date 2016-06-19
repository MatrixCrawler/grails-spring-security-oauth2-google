import grails.util.Holders

/**
 * Always code as if the guy who ends up maintaining your code
 * will be a violent psychopath that knows where you live.
 *
 * - John Woods
 *
 * Created on 19.06.2016
 * @author MatrixCrawler
 */
def appName = grails.util.Metadata.current.'app.name'
def baseURL = Holders.config.grails.serverURL ?: "http://localhost:${System.getProperty('server.port', '8080')}/${appName}"

oauth2 {
    providers {
        google {
            successUri = '/oauth2/google/success'
            failureUri = '/oauth2/google/failure'
            callback = "${baseURL}/oauth2/google/callback"
        }
    }
}