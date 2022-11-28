package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CalculatorDao {
    private JDBCUtil jdbcUtil = null;
    
    public CalculatorDao() {          
        jdbcUtil = new JDBCUtil();  // JDBC
    }
}
