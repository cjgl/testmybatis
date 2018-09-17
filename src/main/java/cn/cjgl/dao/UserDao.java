package cn.cjgl.dao;

import java.util.List;

import cn.cjgl.model.User;

public interface UserDao {
	public void addUser(User user);
	public void modUser(User user);
	public void delUser(User user);
	public List<User> queryUsers(User user);
	public List<User> queryUsers1(User user);
}
