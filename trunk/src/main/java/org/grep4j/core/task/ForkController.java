package org.grep4j.core.task;

import org.grep4j.core.options.Constants;
import org.grep4j.core.options.Options;

/**
 * This to control the maximum number of threads to be used when forking tasks
 * @author marcocast
 *
 */
public class ForkController {

	private static int MAX_GREPTASK_THREADS = 10;

	private ForkController() {
	}

	public static int maxGrepTaskThreads(Options options, int totGrepTasks) {
	    int maxGrepThreads = options.getIntegerValue(Constants.SSH_CONNECTION_LIMIT_OPTION, MAX_GREPTASK_THREADS);
	    
		return totGrepTasks > maxGrepThreads ? maxGrepThreads : totGrepTasks;
	}
}
