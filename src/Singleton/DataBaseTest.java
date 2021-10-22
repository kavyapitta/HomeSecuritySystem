package Singleton;

import static org.junit.jupiter.api.Assertions.*;

class DataBaseTest {

    @org.junit.jupiter.api.Test
    void getInstance() {
        DataBase db1 = DataBase.getInstance();
        DataBase db2 = DataBase.getInstance();
        assertTrue(db1 == db2);
    }
}