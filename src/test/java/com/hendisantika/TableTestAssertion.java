package com.hendisantika;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mysql-docker-compose
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 7/8/24
 * Time: 15:30
 * To change this template use File | Settings | File Templates.
 */
public class TableTestAssertion {
    static void assertTableExists(DataSource dataSource) throws SQLException {
        try (Connection conn = dataSource.getConnection();
             ResultSet resultSet = conn.prepareStatement("SHOW TABLES").executeQuery()) {
            if (resultSet.next()) {
                String table = resultSet.getString(1);
                assertThat(table).isEqualTo("tests");
            } else {
                fail("No results for SHOW TABLES");
            }
        }
    }
}
