package com.example.demo.supplement.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnyMatcherTest {
    
    @DisplayName("임의 값 일치와 정확한 값 일치가 필요한 경우 eq() 메서드를 사용")
    @Test
    void mixAnyAndEq() {
        List<String> mockList = mock(List.class);

        when(mockList.set(anyInt(), eq("123"))).thenReturn("456");

        String old = mockList.set(5, "123");
        assertEquals("456", old);
    }

    @Test
    void anyMatchTest() {
        GameNumGen genMock = mock(GameNumGen.class);
        when(genMock.generate(any())).thenReturn("456");

        String num = genMock.generate(GameLevel.EASY);
        assertEquals("456", num);

        String num2 = genMock.generate(GameLevel.NORMAL);
        assertEquals("456", num2);
    }

}
