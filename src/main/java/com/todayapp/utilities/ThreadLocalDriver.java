package com.todayapp.utilities;

import io.appium.java_client.ios.IOSDriver;

public class ThreadLocalDriver {

    @SuppressWarnings("rawtypes")
	private static ThreadLocal<IOSDriver> tlDriver = new ThreadLocal<IOSDriver>();

    public synchronized static void setTLDriver(IOSDriver<?> iosDriver) {
    	
        tlDriver.set(iosDriver);
    }

    public synchronized static IOSDriver<?> getTLDriver() {
        return tlDriver.get();
    }
}
