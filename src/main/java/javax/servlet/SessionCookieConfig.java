package javax.servlet;

/**
 * Created by wanghm on 2014/12/9.
 */
public interface SessionCookieConfig {
    public void setName(String name);

    public String getName();

    public void setDomain(String domain);

    public String getDemain();

    public void setPath(String path);

    public String getPath();

    public void setComment(String comment);

    public String getComment();

    public void setHttpOnly(boolean httpOnly);

    public boolean isHttpOnly();

    public void setSecure(boolean secure);

    public boolean isSecure();

    public void setMaxAge(int maxAge);

    public int getMaxAge();

}
