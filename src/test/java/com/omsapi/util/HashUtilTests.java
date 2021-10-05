package com.omsapi.util;

import com.omsapi.utils.HasUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class HashUtilTests {

    @Test
    public void getScecureHashTest() {
        String hash = HasUtil.getSecureHash("123");
        System.out.println(hash);
        Assertions.assertThat(hash.length()).isEqualTo(64);
    }
}
