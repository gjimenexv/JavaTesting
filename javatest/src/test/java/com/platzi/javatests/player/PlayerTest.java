package com.platzi.javatests.player;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PlayerTest {

    @Test
    public void loose_when_dice_number_is_too_low() {
        Dice dice = mock(Dice.class);

        when(dice.roll()).thenReturn(2);

        Player player = new Player(dice, 5);
        assertFalse(player.play());
    }
    @Test
    public void wins_when_dice_number_is_higger() {
        Dice dice = mock(Dice.class);

        when(dice.roll()).thenReturn(5);

        Player player = new Player(dice, 4);
        assertTrue(player.play());
    }
}