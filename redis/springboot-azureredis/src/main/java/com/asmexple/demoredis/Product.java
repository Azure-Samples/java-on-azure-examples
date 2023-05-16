
package com.asmexple.demoredis;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
@RedisHash("product")
public class Product implements Serializable {
    private String id;
    private String name;

}