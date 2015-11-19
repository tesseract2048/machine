package com.qunar.coach.machine.adapter.factory;

import com.szlw.station.sessions.interfaces.StationAgent;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;

/**
 * @author weixin.gong
 * @date 15-11-19 上午10:25
 */
public class StationAgentFactory {

    public static StationAgent getStationAgent() {
        return StationAgentHolder.stationAgent;
    }

    private static class  StationAgentHolder {
        private static final StationAgent stationAgent;

        static {
            try {
                Properties props = new Properties();
                //根据不同的服务器有不同的设置，下面是JBoss的设置
                props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
                props.setProperty(Context.PROVIDER_URL, "192.168.122.231:1098");
                InitialContext ctx = new InitialContext(props);
                stationAgent = (StationAgent)ctx.lookup("StationAgentBean/remote");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
