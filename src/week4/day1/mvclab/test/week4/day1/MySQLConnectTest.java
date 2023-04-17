package week4.day1;

import com.sun.jdi.connect.spi.Connection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class MySQLConnectTest {

    @Test
    @DisplayName("DB 서버 접속 확인")
    void connect() {
        assumeTrue(MySQLConnect.connect() instanceof Connection);
    }

    @Test
    void close() {
    }
}