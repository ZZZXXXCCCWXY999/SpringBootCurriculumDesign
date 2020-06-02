package xyz.zxcwxy999.curriculumdesign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import xyz.zxcwxy999.curriculumdesign.dao.UserDao;
import xyz.zxcwxy999.curriculumdesign.domain.User;

@Service("UserService")
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    UserDao userDao;

    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) userDao.findByUsername(username);
    }

    /**
     * 新增、编辑、保存用户
     *
     * @param user
     * @return
     */
    @Override
    public int saveOrUpdateUser(User user) {
        return userDao.save(user);
    }

    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    @Override
    public int registerUser(User user) {
        return userDao.save(user);
    }

    /**
     * 删除用户
     *
     * @param id
     */
    @Override
    public void removeUser(int id) {
        userDao.deleteById(id);
    }

    /**
     * 根据id获取用户
     *
     * @param id
     * @return
     */
    @Override
    public User getUserById(int id) {
        return userDao.findById(id);
    }

    /**
     * 根据用户名进行分页模糊查询
     *
     * @param name
     * @return
     */
    @Override
    public User[] listUsersByNameLike(String name) {
        //模糊查询
        name = "%" + name + "%";
        User[] users = userDao.findByNameLike(name);
        return users;
    }
}
