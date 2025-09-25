package top.wby.boot.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Adress implements Serializable {

    @Serial
    private static final long serialVersionUID = -3535198995904721111L;
    private String province;
    private String city;
}
