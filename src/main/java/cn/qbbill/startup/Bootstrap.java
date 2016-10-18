package cn.qbbill.startup;

import cn.qbbill.connector.http.HttpConnector;

/**
 * Created by 钱斌 on 2016/9/21.
 */
public final class Bootstrap {
    public static void main(String[] args) {
        HttpConnector connector = new HttpConnector();
        connector.start();
    }
}
