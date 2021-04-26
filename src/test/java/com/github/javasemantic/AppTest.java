package com.github.javasemantic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AppTest
{
    @Mock MockBeanTest mockBeanTest;

    @Test
    public void when_helloWorld_should_returnCorrectValue()
    {
        var app = new App();
        assertEquals("Hello World!", app.returnHelloWorld());
    }

    @Test
    public void when_mockBean_should_beMockBean()
    {
        when(mockBeanTest.anotherSillyReturn())
            .thenReturn("my super mock bean!");

        assertEquals("my super mock bean!", mockBeanTest.anotherSillyReturn());
    }
}
