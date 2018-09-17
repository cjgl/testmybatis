package cn.cjgl.dao;

import java.util.List;

import cn.cjgl.model.Department;

public interface DepartmentDao {
	public void addDepartment(Department department);
	public void modDepartment(Department department);
	public void delDepartment(Department department);
	public List<Department> queryDepartments(Department department);
	public List<Department> queryDepartments1(Department department);
}
