package com.baizhi.ljy.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Admin implements Serializable {
    @Id
    private String id;
    private String username;
    private String password;

}
