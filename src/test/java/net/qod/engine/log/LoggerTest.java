package net.qod.engine.log;

import org.junit.jupiter.api.Test;

class LoggerTest {
    @Test
    void function() {
        Logger logger = new Logger(System.out);
        logger.info("Started Logger");
        logger.error("This should be in red!");
        logger.debug("This shouldn't be in red!");
    }
}