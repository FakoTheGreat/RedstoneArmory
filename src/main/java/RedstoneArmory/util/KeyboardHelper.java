package RedstoneArmory.util;

import org.lwjgl.input.Keyboard;

public class KeyboardHelper {
    public static boolean isShiftDown() {
        return Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
    }
}