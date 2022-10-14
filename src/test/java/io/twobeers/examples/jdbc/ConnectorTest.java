package io.twobeers.examples.jdbc;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class ConnectorTest {

    @Test
    public void checkingMeaningOfLife() throws Exception {
        Connector connector = new Connector();
        connector.connect();
        var questionOfLife = connector.getDbData();
        assertTrue(questionOfLife.isPresent());
        assertEquals(Integer.valueOf(42), questionOfLife.get());
        connector.close();
    }
}