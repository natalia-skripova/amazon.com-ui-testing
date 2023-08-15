package utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import static constant.FilePathConstants.LOG_PROPERTIES;

public class LogUtils {

    private static Logger log;

    private LogUtils() {

    }

    public static Logger getLogger() {
        if (log == null) {
            log = Logger.getLogger(LogUtils.class);
            PropertyConfigurator.configure(LOG_PROPERTIES);
        }
        return log;
    }
}
