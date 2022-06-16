package com.example.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @desc
 * @auth llp
 * @date 2022年06月12日 23:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

        @TableId(type = IdType.AUTO)
        private Long id;
        private String name;
        private Integer age;
        private String email;

        @TableField(fill = FieldFill.INSERT)
        private Date createTime;
        @TableField(fill = FieldFill.INSERT_UPDATE)
        private Date updateTime;

        @Version
        private Integer version;

        @TableLogic     // 逻辑删除
        private Integer deleted;
}
