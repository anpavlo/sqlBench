package com.sql.bench.service;

import com.sql.bench.dto.MeasureResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class SqlBenchServiceImpl implements SqlBenchService {

    @Autowired
    DataSource dataSource;

    @Override
    public MeasureResultDTO runBench(int queriesQuantity) {

        Connection conn = null;
        MeasureResultDTO measureResultDTO = new MeasureResultDTO();
        try {
            long start = System.nanoTime();
            conn = dataSource.getConnection();
            long elapsed = System.nanoTime() - start;
            measureResultDTO.setConnectionTime(nanoToStrMicro(elapsed));

            //according to requirements to use commit for INSERT queries, set auto commit to false
            conn.setAutoCommit(false);
            runInsert(queriesQuantity, conn, measureResultDTO);

            //after run Insert queries, setup to previous state
            conn.setAutoCommit(true);
            runSelect(queriesQuantity, conn, measureResultDTO);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return measureResultDTO;
    }

    private void runInsert(int queriesQuantity, Connection conn, MeasureResultDTO measureResultDTO) throws SQLException {
        String sql = "INSERT INTO test_table1 (login, password) Values (?, ?)";
        List<Long> insertTimes = new ArrayList<>();
        for (int i = 0; i < queriesQuantity; i++) {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, "value " + i);
            preparedStatement.setString(2, "value " + i);

            long start = System.nanoTime();
            preparedStatement.executeUpdate();
            conn.commit();
            long elapsed = System.nanoTime() - start;
            insertTimes.add(elapsed);

        }
        long avg = (long)insertTimes.stream().mapToLong(value -> value).average().orElse(0);
        long max = insertTimes.stream().mapToLong(value -> value).max().orElse(0);
        long min = insertTimes.stream().mapToLong(value -> value).min().orElse(0);
        long total = insertTimes.stream().mapToLong(value -> value).sum();

        measureResultDTO.setInsertMinTime(nanoToStrMicro(min));
        measureResultDTO.setInsertMaxTime(nanoToStrMicro(max));
        measureResultDTO.setInsertAvgTime(nanoToStrMicro(avg));
        measureResultDTO.setInsertTotalTime(nanoToStrMicro(total));

    }

    private void runSelect(int exeQuantity, Connection conn, MeasureResultDTO measureResultDTO) throws SQLException {
        List<Long> selectTimes = new ArrayList<>();
        int counter = 0;
        for (int i = 0; i < exeQuantity; i++) {

            Statement statement = conn.createStatement();

            long start = System.nanoTime();
            ResultSet rs = statement.executeQuery("SELECT id, login FROM test_table1 WHERE id = " + i);
            long elapsed = System.nanoTime() - start;
            selectTimes.add(elapsed);
            // add some logic to make reason for having result set
            if (rs != null) counter++;

        }
        long avg = (long)selectTimes.stream().mapToLong(value -> value).average().orElse(0);
        long max = selectTimes.stream().mapToLong(value -> value).max().orElse(0);
        long min = selectTimes.stream().mapToLong(value -> value).min().orElse(0);
        long total = selectTimes.stream().mapToLong(value -> value).sum();

        measureResultDTO.setSelectMinTime(nanoToStrMicro(min));
        measureResultDTO.setSelectMaxTime(nanoToStrMicro(max));
        measureResultDTO.setSelectAvgTime(nanoToStrMicro(avg));
        measureResultDTO.setSelectTotalTime(nanoToStrMicro(total));

        System.out.println(counter + " SELECT statement has been executed");
    }

    // convert to microseconds
    private String nanoToStrMicro(long nano) {
        return Long.toString(TimeUnit.MICROSECONDS.convert(nano, TimeUnit.NANOSECONDS));
    }

}
