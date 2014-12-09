package javax.servlet;

import javax.servlet.annotation.MultipartConfig;

/**
 * Created by wanghm on 2014/12/9.
 */
public class MultipartConfigElement {
    private String location;
    private long maxFileSize;
    private long maxRequestSize;
    private int fileSizeThreshold;

    public MultipartConfigElement(String location, long maxFileSize,
                                  long maxRequestSize, int fileSizeThreshold) {
        if (location == null) {
            this.location = "";
        } else {
            this.location = location;
        }
        this.maxFileSize = maxFileSize;
        this.maxRequestSize = maxRequestSize;
        this.fileSizeThreshold = fileSizeThreshold;
    }

    public MultipartConfigElement(String location) {
        if (location == null) {
            this.location = "";
        } else {
            this.location = location;
        }
        this.maxFileSize = -1L;
        this.maxRequestSize = -1L;
        this.fileSizeThreshold = 0;
    }

    public MultipartConfigElement(MultipartConfig annotation) {
        this.location = annotation.location();
        this.maxFileSize = annotation.maxFileSize();
        this.maxRequestSize = annotation.maxRequestSize();
        this.fileSizeThreshold = annotation.fileSizeThreshold();
    }

    public String getLocation() {
        return location;
    }

    public long getMaxFileSize() {
        return maxFileSize;
    }

    public long getMaxRequestSize() {
        return maxRequestSize;
    }

    public int getFileSizeThreshold() {
        return fileSizeThreshold;
    }
}
