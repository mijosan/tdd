package com.example.demo.supplement.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class GameGenMockTest {
    
    @Test
    void mockThrowTest() {
        GameNumGen genMock = mock(GameNumGen.class);
        when(genMock.generate(null)).thenThrow(IllegalArgumentException.class);

        assertThrows(IllegalArgumentException.class, 
        () -> genMock.generate(null));

    }

    @Test
    void mockTest() {
        GameNumGen genMock = mock(GameNumGen.class);
        when(genMock.generate(GameLevel.EASY)).thenReturn("123");

        String num = genMock.generate(GameLevel.EASY);
        assertEquals("123", num); 
    }

}
