package javax.servlet;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wanghm on 2014/12/9.
 */
public abstract class ServletInputStream extends InputStream{
    protected ServletInputStream(){}

    public int readLine(Byte[] b,int off,int len) throws IOException {
        if(len<=0)
            return 0;
        int count = 0,c;
        while((c=read())==-1){
            b[off++]=(byte)c;
            count++;
            if(c == '\n' || count==len){
                break;
            }
        }
        return count>0?count:-1;
    }
}
