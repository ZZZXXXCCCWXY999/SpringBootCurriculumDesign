package xyz.zxcwxy999.curriculumdesign.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import xyz.zxcwxy999.curriculumdesign.domain.User;

import java.util.Optional;

public interface UserService {
    /**
     * 新增、编辑、保存用户
     *
     * @param user
     * @return
     */
    int saveOrUpdateUser(User user);

    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    int registerUser(User user);

    /**
     * 删除用户
     *
     * @param id
     */
    void removeUser(int id);

    /**
     * 根据id获取用户
     *
     * @param id
     * @return
     */
    User getUserById(int id);

    /**
     * 根据用户名进行分页模糊查询
     *
     * @param name
     * @return
     */
    User[] listUsersByNameLike(String name);
}
