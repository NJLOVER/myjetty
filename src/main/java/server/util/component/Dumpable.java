package server.util.component;

import java.io.IOException;

/**
 * Created by wanghm on 2014/12/10.
 */
public interface Dumpable {
    String dump();
    void dump(Appendable out,String indent) throws IOException;
}
