package myjetty.ssl;

import myjetty.LifeCycle;
import myjetty.component.Destroyable;

/**
 * Created by wanghm on 2014/12/8.
 */
public interface handler extends LifeCycle,Destroyable {
    public void handle(String target,Request baseRequest,HttpServletRequest request,HttpServletResponse response);
}
