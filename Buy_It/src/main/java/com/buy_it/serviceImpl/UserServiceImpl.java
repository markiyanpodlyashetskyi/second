package com.buy_it.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.buy_it.dao.UserDao;
import com.buy_it.entity.User;

@Service("userDetailService")
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	public void save(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		userDao.save(user);
	}

	public User findOneById(int id) {
		return userDao.findOne(id);
	}

	public void delete(int id) {
		userDao.delete(id);
	}

	public void delete(String userName) {
		userDao.deleteUserByName(userName);
	}

	public Iterable<User> getAll() {
		return userDao.findAll();
	}

	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		User user;
		try {
			user = userDao.findOneByName(userName);
		} catch (NoResultException e) {
			return null;
		}

		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				authorities);

	}
}
