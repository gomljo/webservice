package com.lifi.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트(){
        // given
        String name_ = "test";
        int amount_ = 1000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name_, amount_);

        // then

        assertThat(dto.getName()).isEqualTo(name_);
        assertThat(dto.getAmount()).isEqualTo(amount_);
    }
}
