/* Copyright 2006-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * Always code as if the guy who ends up maintaining your code
 * will be a violent psychopath that knows where you live.
 *
 * - John Woods
 *
 * Created on 19.06.2016
 * @author MatrixCrawler
 */

security {
    oauth2 {
        providers {
            google {
                successUri = "/oauth2/google/success"
                failureUri = "/oauth2/google/failure"
                callback = "/oauth2/google/callback"
                api_key = "changeme_apikey"
                api_secret = "changeme_apisecret"
            }
        }
    }
}