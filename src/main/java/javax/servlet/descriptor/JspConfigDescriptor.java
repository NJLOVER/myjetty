package javax.servlet.descriptor;

import java.util.Collection;

/**
 * Created by wanghm on 2014/12/9.
 */
public interface JspConfigDescriptor {

    public Collection<TaglibDescriptor> getTaglibs();

    public Collection<JspPropertyGroupDescriptor> getJspPropertyGroups();
}
