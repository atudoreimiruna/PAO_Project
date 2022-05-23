package Repository;

import Mapper.RowMapper;
import Service.DatabaseQueryExecutorService;

import java.util.List;

public class Repository {
    protected static <T> List<T> readQuery(String sql, RowMapper<T> rowMapper){
        return DatabaseQueryExecutorService.executeReadQuery(sql, rowMapper).stream().map(x -> (T)x).toList();
    }

    protected static Integer executeQuery(String sql){
        return DatabaseQueryExecutorService.executeUpdateQuery(sql);
    }


    protected static String addQuotMark(String s){
        return "'" + s + "'";
    }
}