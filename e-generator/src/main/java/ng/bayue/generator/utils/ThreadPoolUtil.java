package ng.bayue.generator.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ThreadPoolUtil {

	private static final int POOL_SIZE = 8;
	private static volatile ExecutorService fixedThreadPool;

	public static ExecutorService getFixedThreadPool() {
		if (null == fixedThreadPool) {
			synchronized (ThreadPoolUtil.class) {
				fixedThreadPool = Executors.newFixedThreadPool(POOL_SIZE);
			}
		}
		return fixedThreadPool;
	}

	public static void shutDown() {
		if (null != fixedThreadPool && !fixedThreadPool.isShutdown()) {
			fixedThreadPool.shutdown();
		}
	}

}
