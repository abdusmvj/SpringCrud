package com.spring.dao;

import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;  
import com.spring.beans.Emp;
import com.spring.controllers.EmpController;

public class EmpDao 
{
	
@Autowired
	DataSource dataSource;
	
	JdbcTemplate template;  
	  
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}  
	public int save(Emp p){  
	    String sql="insert into emp_crude_ex(name,salary,designation) values('"+p.getName()+"','"+p.getSalary()+"','"+p.getDesignation()+"')";  
	    return template.update(sql);  
	}  
	public int update(Emp p){  
	    String sql="update emp_crude_ex set name='"+p.getName()+"', salary='"+p.getSalary()+"', designation='"+p.getDesignation()+"' where id="+p.getId()+"";  
	    return template.update(sql);  
	}  
	public int delete(int id){  
	    String sql="delete from emp_crude_ex where id="+id+"";  
	    return template.update(sql);  
	}  
	public Emp getEmpById(int id){  
	    String sql="select * from emp_crude_ex where id=?";  
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Emp>(Emp.class));  
	}  
	public List<Emp> getEmployees(){  
	    return template.query("select * from emp_crude_ex",new RowMapper<Emp>(){  
	        public Emp mapRow(ResultSet rs, int row) throws SQLException
	        {  
	          Emp e=new Emp();
	            e.setId(rs.getInt(1));
	          
	            e.setName(rs.getString(2));
	            e.setSalary(rs.getFloat(3)); 
	           e.setDesignation(rs.getString(4)); 
	            return e;  
	        }  
	    });  
	}  
}
