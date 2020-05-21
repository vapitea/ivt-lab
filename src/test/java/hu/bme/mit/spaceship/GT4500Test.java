package hu.bme.mit.spaceship;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class GT4500Test {

    private GT4500 ship;
    private TorpedoStore mockTorpedoStore1;
    private TorpedoStore mockTorpedoStore2;


    @BeforeEach
    public void init() {

        mockTorpedoStore1 = mock(TorpedoStore.class);
        mockTorpedoStore2 = mock(TorpedoStore.class);

        this.ship = new GT4500(mockTorpedoStore1, mockTorpedoStore2);
    }

    @Test
    public void fireTorpedo_Single_Success() {
        // Arrange
        when(mockTorpedoStore1.getTorpedoCount()).thenReturn(10);
        when(mockTorpedoStore2.getTorpedoCount()).thenReturn(10);
        when(mockTorpedoStore1.isEmpty()).thenReturn(false);
        when(mockTorpedoStore2.isEmpty()).thenReturn(false);
        when(mockTorpedoStore1.fire(anyInt())).thenReturn(true);
        when(mockTorpedoStore2.fire(anyInt())).thenReturn(true);


        // Act
        ship.fireTorpedo(FiringMode.SINGLE);

        // Assert
        verify(mockTorpedoStore1, times(1)).fire(1);
        verify(mockTorpedoStore2, times(0)).fire(1);

    }

    @Test
    public void fireTorpedo_All_Success() {
        // Arrange
        when(mockTorpedoStore1.getTorpedoCount()).thenReturn(10);
        when(mockTorpedoStore2.getTorpedoCount()).thenReturn(10);
        when(mockTorpedoStore1.isEmpty()).thenReturn(false);
        when(mockTorpedoStore2.isEmpty()).thenReturn(false);
        when(mockTorpedoStore1.fire(anyInt())).thenReturn(true);
        when(mockTorpedoStore2.fire(anyInt())).thenReturn(true);

        // Act
        ship.fireTorpedo(FiringMode.ALL);

        // Assert
        verify(mockTorpedoStore1, times(1)).fire(1);
        verify(mockTorpedoStore2, times(1)).fire(1);

    }

}
