package server.nio;

import org.eclipse.jetty.io.nio.SelectorManager;

import java.nio.channels.ServerSocketChannel;

/**
 * Created by wanghm on 2014/12/15.
 */
public class SelectChannelConnector extends AbstractNIOConnector {
    protected ServerSocketChannel _acceptChannel;
    private int _lowResourcesConnections;
    private int _lowResourcesMaxIdleTime;
    private int _localPort=-1;

   private final class ConnectorSelectorManager extends SelectorManager{

   }
}
