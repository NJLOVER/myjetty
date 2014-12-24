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

    public final static String COOKIE= "Cookie",
            SET_COOKIE= "Set-Cookie",
            SET_COOKIE2= "Set-Cookie2",
            MIME_VERSION= "MIME-Version",
            IDENTITY= "identity";

    public final static int CONNECTION_ORDINAL= 1,
            DATE_ORDINAL= 2,
            PRAGMA_ORDINAL= 3,
            TRAILER_ORDINAL= 4,
            TRANSFER_ENCODING_ORDINAL= 5,
            UPGRADE_ORDINAL= 6,
            VIA_ORDINAL= 7,
            WARNING_ORDINAL= 8,
            ALLOW_ORDINAL= 9,
            CONTENT_ENCODING_ORDINAL= 10,
            CONTENT_LANGUAGE_ORDINAL= 11,
            CONTENT_LENGTH_ORDINAL= 12,
            CONTENT_LOCATION_ORDINAL= 13,
            CONTENT_MD5_ORDINAL= 14,
            CONTENT_RANGE_ORDINAL= 15,
            CONTENT_TYPE_ORDINAL= 16,
            EXPIRES_ORDINAL= 17,
            LAST_MODIFIED_ORDINAL= 18,
            ACCEPT_ORDINAL= 19,
            ACCEPT_CHARSET_ORDINAL= 20,
            ACCEPT_ENCODING_ORDINAL= 21,
            ACCEPT_LANGUAGE_ORDINAL= 22,
            AUTHORIZATION_ORDINAL= 23,
            EXPECT_ORDINAL= 24,
            FORWARDED_ORDINAL= 25,
            FROM_ORDINAL= 26,
            HOST_ORDINAL= 27,
            IF_MATCH_ORDINAL= 28,
            IF_MODIFIED_SINCE_ORDINAL= 29,
            IF_NONE_MATCH_ORDINAL= 30,
            IF_RANGE_ORDINAL= 31,
            IF_UNMODIFIED_SINCE_ORDINAL= 32,
            KEEP_ALIVE_ORDINAL= 33,
            MAX_FORWARDS_ORDINAL= 34,
            PROXY_AUTHORIZATION_ORDINAL= 35,
            RANGE_ORDINAL= 36,
            REQUEST_RANGE_ORDINAL= 37,
            REFERER_ORDINAL= 38,
            TE_ORDINAL= 39,
            USER_AGENT_ORDINAL= 40,
            X_FORWARDED_FOR_ORDINAL= 41,
            ACCEPT_RANGES_ORDINAL= 42,
            AGE_ORDINAL= 43,
            ETAG_ORDINAL= 44,
            LOCATION_ORDINAL= 45,
            PROXY_AUTHENTICATE_ORDINAL= 46,
            RETRY_AFTER_ORDINAL= 47,
            SERVER_ORDINAL= 48,
            SERVLET_ENGINE_ORDINAL= 49,
            VARY_ORDINAL= 50,
            WWW_AUTHENTICATE_ORDINAL= 51,
            COOKIE_ORDINAL= 52,
            SET_COOKIE_ORDINAL= 53,
            SET_COOKIE2_ORDINAL= 54,
            MIME_VERSION_ORDINAL= 55,
            IDENTITY_ORDINAL= 56,
            CACHE_CONTROL_ORDINAL=57,
            PROXY_CONNECTION_ORDINAL=58,
            X_FORWARDED_PROTO_ORDINAL=59,
            X_FORWARDED_SERVER_ORDINAL=60,
            X_FORWARDED_HOST_ORDINAL=61;

    public final static HttpHeaders CACHE= new HttpHeaders();





}
