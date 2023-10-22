package edu.hw2.Task3;

import edu.hw2.Task3.Connection;
import edu.hw2.Task3.ConnectionManager;
import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    private Random rand = new Random();

    @Override
    public Connection getConnection() {
        if (rand.nextBoolean()) {
            return new FaultyConnection();
        }
        return new StableConnection();
    }
}
