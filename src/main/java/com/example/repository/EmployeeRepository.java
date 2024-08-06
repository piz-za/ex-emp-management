package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.example.domain.Employee;

@Repository
public class EmployeeRepository {

    /*
     * オブジェクトへの参照情報をSpringFramework から注⼊してもらうようにする
     */
    @Autowired
    private NamedParameterJdbcTemplate template;


    public static final RowMapper<Employee> EMPLOYEE_ROW_MAPPER = (rs, i) -> {
        Employee employee = new Employee();
        employee.setId(rs.getInt("id"));
        employee.setName(rs.getString("name"));
        employee.setImage(rs.getString("image"));
        employee.setGender(rs.getString("gender"));
        employee.setHireDate(rs.getDate("hireDate"));
        employee.setMailAddress(rs.getString("mailAddress"));
        employee.setZipCode(rs.getString("zipCode"));
        employee.setAddress(rs.getString("address"));
        employee.setTelephone(rs.getString("telephone"));
        employee.setSalary(rs.getInt("salary"));
        employee.setCharacteristics(rs.getString("characteristics"));
        employee.setDependentsCount(rs.getInt("dependentsCount"));
        return employee;
    };

    /*
     * 全件検索を行う(リポジトリのフィールドが検索項目)
     * (1 件も存在しない場合は null を返す)
     * @return 全従業員一覧
     */
    public List<Employee> findAll() {

        String sql = "SELECT * FROM employees ORDER BY hire_date DESC";
        List<Employee> employeesList = template.query(sql, EMPLOYEE_ROW_MAPPER);

        if (employeesList.size() == 0) {
            return null;
        }
        return employeesList;

    }

    /*
     * 主キーから従業員の情報を取得するメソッド
     * 
     * @return 主キーで指定した従業員の情報
     */
    public Employee load(Integer id) {

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", id);

        String sql = "SELECT * FROM employees "
                + "WHERE id=:id";
        Employee employee = template.queryForObject(sql, param, EMPLOYEE_ROW_MAPPER);
        return employee;
    }

    /*
     * idを除いた従業員情報の全てのカラムを更新するメソッド
     * 
     * @return 主キーで指定した従業員の情報
     */
    public void update(Employee employee) {

        SqlParameterSource param = new MapSqlParameterSource()
        .addValue("id", employee.getId())
        .addValue("name", employee.getName())
        .addValue("image", employee.getImage())
        .addValue("gender", employee.getGender())
        .addValue("hireDate", employee.getHireDate())
        .addValue("mailAddress", employee.getMailAddress())
        .addValue("zipCode", employee.getZipCode())
        .addValue("address", employee.getAddress())
        .addValue("telephone", employee.getTelephone())
        .addValue("salary", employee.getSalary())
        .addValue("characteristics", employee.getCharacteristics())
        .addValue("dependentsCount", employee.getDependentsCount());
        

        String sql = "UPDATE employee SET " +
        "name = :name, " +
        "image = :image, " +
        "gender = :gender, " +
        "hire_date = :hireDate, " +
        "mail_address = :mailAddress, " +
        "zip_code = :zipCode, " +
        "address = :address, " +
        "telephone = :telephone, " +
        "salary = :salary, " +
        "characteristics = :characteristics, " +
        "dependents_count = :dependentsCount " +
        "WHERE id = :id";

        template.update(sql, param);
    }

}
