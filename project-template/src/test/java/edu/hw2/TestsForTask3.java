package edu.hw2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import edu.hw2.Task3.Connection;
import edu.hw2.Task3.ConnectionManager;
import edu.hw2.Task3.DefaultConnectionManager;
import edu.hw2.Task3.FaultyConnection;
import edu.hw2.Task3.FaultyConnectionManager;

public class TestsForTask3 {
    @Test
    @DisplayName("DefaultConnectionManager --> Connection interface implementation")
    void check_DefaultConnectionManager_getConnection() {

        ConnectionManager connectionManager = new DefaultConnectionManager();
        Connection connection = connectionManager.getConnection();
        assertThat(connection).isInstanceOf(Connection.class);
    }

    @Test
    @DisplayName("FaultyConnectionManager --> FaultyConnection")
    void check_FaultyConnectionManager_getConnection() {

        ConnectionManager connectionManager = new FaultyConnectionManager();
        Connection connection = connectionManager.getConnection();
        assertThat(connection).isInstanceOf(FaultyConnection.class);
    }
}
