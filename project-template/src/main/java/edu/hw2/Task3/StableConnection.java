package edu.hw2.Task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class StableConnection implements Connection {
    private final static Logger LOGGER = LogManager.getLogger();


    @Override
    public void execute(String command) {

        LOGGER.info("Stable - Executed command: " + command);
    }

    @Override
    public void close() throws Exception {

    }
}
