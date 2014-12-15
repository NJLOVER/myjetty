package http;

import org.eclipse.jetty.io.BufferCache;

/**
 * Created by wanghm on 2014/12/15.
 */
public class HttpHeaders extends BufferCache {
    public final static String
        CONNECTION = "Connection",
        CACHE_CONTROL = "Coche_Control",
        DATE = "Date",
        PRAGMA = "Pragma",
        PROXY_CONNECTION = "Proxy_Connection",
        TRAILER = "Trailer",
        TRANSFER_ENCODING = "Transfer_Encoding",
        UPGRADE = "Upgrade",
        VIA = "Via",
        WARNING = "Warning",
        NEGOTIATE = "Negotiate";

    public final static String
        ALLOW = "Allow",
        CONTENT_ENCODING = "Content_Encoding",
        CONTENT＿LANGUAGE = "Content_Language",
        CONTENT_LENGTH = "Content_Length",
        CONTENT_LOCATION = "Content_Location",
        CONTENT_MD5 = "Content_Md5",
        CONTENT_RANGE = "Content_Range",
        CONTENT_TYPE = "Content_type",
        EXPRISE = "Exprise",
        LAST_MODIFIED = "Last_Modified";

    public final static String
            ACCEPT_CHARSET= "Accept-Charset",
            ACCEPT_ENCODING= "Accept-Encoding",
            ACCEPT_LANGUAGE= "Accept-Language",
            AUTHORIZATION= "Authorization",
            EXPECT= "Expect",
            FORWARDED= "Forwarded",
            FROM= "From",
            HOST= "Host",
            IF_MATCH= "If-Match",
            IF_MODIFIED_SINCE= "If-Modified-Since",
            IF_NONE_MATCH= "If-None-Match",
            IF_RANGE= "If-Range",
            IF_UNMODIFIED_SINCE= "If-Unmodified-Since",
            KEEP_ALIVE= "Keep-Alive",
            MAX_FORWARDS= "Max-Forwards",
            PROXY_AUTHORIZATION= "Proxy-Authorization",
            RANGE= "Range",
            REQUEST_RANGE= "Request-Range",
            REFERER= "Referer",
            TE= "TE",
            USER_AGENT= "User-Agent",
            X_FORWARDED_FOR= "X-Forwarded-For",
            X_FORWARDED_PROTO= "X-Forwarded-Proto",
            X_FORWARDED_SERVER= "X-Forwarded-Server",
            X_FORWARDED_HOST= "X-Forwarded-Host";

    public final static String ACCEPT_RANGES= "Accept-Ranges",
            AGE= "Age",
            ETAG= "ETag",
            LOCATION= "Location",
            PROXY_AUTHENTICATE= "Proxy-Authenticate",
            RETRY_AFTER= "Retry-After",
            SERVER= "Server",
            SERVLET_ENGINE= "Servlet-Engine",
            VARY= "Vary",
            WWW_AUTHENTICATE= "WWW-Authenticate";





}
