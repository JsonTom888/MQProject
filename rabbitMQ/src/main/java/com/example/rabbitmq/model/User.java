package com.example.rabbitmq.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author tom
 * @version V1.0
 * @date 2020/9/13 21:02
 */
@Data
@ToString
public class User implements Serializable {
    String name;
    String pass;
}
