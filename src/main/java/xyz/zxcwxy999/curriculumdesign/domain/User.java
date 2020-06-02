package xyz.zxcwxy999.curriculumdesign.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Mapper
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private String user_id;//用户的唯一标识
    private String user_name;//用户名称，用户登录的唯一标识
    private String user_pw;//用户密码
    private String user_phone;//用户电话
    private Timestamp registerTime;//注册时间
    private String user_email;//用户邮箱
    private Integer user_sex;//用户性别

}