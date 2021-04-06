package com.richur.venus.spring.ioc;

import com.richur.venus.spring.ioc.annotation.Super;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author richur
 */
@Setter
@Getter
@ToString
@Super
public class SuperUser extends User{
    private String level;


}
