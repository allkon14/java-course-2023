package edu.hw2.Task3;

import edu.hw2.Task3.Connection;
import edu.hw2.Task3.ConnectionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnection implements Connection {
    private final static Logger LOGGER = LogManager.getLogger();
    @Override
    public void execute(String command) throws ConnectionException {
        LOGGER.info("Fault - Executed command with fault: " + command);
    }

    @Override
    public void close() throws Exception {
    }
}
