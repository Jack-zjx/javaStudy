package com.xu.study02;

import java.math.BigDecimal;
import java.sql.*;

public class JdbcDemo {

    private static final String URL =
            "jdbc:mysql://localhost:3306/school?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf8";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    // 查询
    public static void query(long classId) throws SQLException {
        String sql = "SELECT id, name, class_id FROM student WHERE class_id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, classId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.printf("%d | %s | %d%n",
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getLong("class_id"));
                }
            }
        }
    }

    // 插入并返回自增主键
    public static long insert(String name, long classId) throws SQLException {
        String sql = "INSERT INTO student(name, class_id) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(
                     sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, name);
            ps.setLong(2, classId);
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                return keys.next() ? keys.getLong(1) : -1L;
            }
        }
    }

    // 事务：转账，任何一步失败全部回滚
    public static void transfer(long fromId, long toId, BigDecimal amount)
            throws SQLException {
        String deduct = "UPDATE account SET balance = balance - ? " +
                "WHERE id = ? AND balance >= ?";
        String add = "UPDATE account SET balance = balance + ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            conn.setAutoCommit(false);
            try (PreparedStatement ps1 = conn.prepareStatement(deduct);
                 PreparedStatement ps2 = conn.prepareStatement(add)) {

                ps1.setBigDecimal(1, amount);
                ps1.setLong(2, fromId);
                ps1.setBigDecimal(3, amount);
                if (ps1.executeUpdate() != 1) {
                    throw new IllegalStateException("余额不足或账户不存在");
                }

                ps2.setBigDecimal(1, amount);
                ps2.setLong(2, toId);
                if (ps2.executeUpdate() != 1) {
                    throw new IllegalStateException("收款账户不存在");
                }

                conn.commit();
            } catch (SQLException | RuntimeException e) {
                conn.rollback();
                throw e;
            } finally {
                conn.setAutoCommit(true);
            }
        }
    }
}
