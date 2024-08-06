package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.example.domain.Administrator;

@Repository
public class AdministratorRepository {

    /*
     * RowMapperのフィールド部分をラムダ式で定義
     * 
     * @return 検索結果
     */
    public static final RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPER = (rs, i) -> {
        Administrator administrator = new Administrator();
        administrator.setId(rs.getInt("id"));
        administrator.setName(rs.getString("name"));
        administrator.setMailAddress(rs.getString("mailAddress"));
        administrator.setPassword(rs.getString("password"));
        return administrator;
    };

    /*
     * オブジェクトへの参照情報をSpringFramework から注⼊してもらうようにする
     */
    @Autowired
    private NamedParameterJdbcTemplate template;

    /*
     * idを除く管理者情報を挿入するメソッド
     * 
     */
    public void insert(Administrator administrator) {

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("insname", administrator.getName())
                .addValue("insmail", administrator.getMailAddress())
                .addValue("inspassword", administrator.getPassword());

        String sql = "INSERT INTO administrators "
                + "VALUES(:insname,:insmail,:inspassword)";

        template.update(sql, param);

    }

    /*
     * メールアドレスとパスワードから管理者情報を取得する
     * 1 件も存在しない場合は null を返す
     * 
     * @return 管理者情報(1件)
     */

    public Administrator findByMailAddressAndPassword(String mailAddress, String password) {
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("srmail", mailAddress)
                .addValue("srpassword", password);

        String sql = "SELECT mail_address,password FROM administrators "
                + "WHERE mail_address=:srmail AND password=:srpassword";

        List<Administrator> administratorList = template.query(sql, param, ADMINISTRATOR_ROW_MAPPER);
        if (administratorList.size() == 0) {
            return null;
        }

        return administratorList.get(0);
    }

}
