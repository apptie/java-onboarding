package onboarding.problem2;

import static onboarding.problem2.consts.CryptogramIndexConst.CRYPTOGRAM_DUPLICATE_START_INDEX;
import static onboarding.problem2.consts.CryptogramIndexConst.CRYPTOGRAM_START_INDEX;

import java.util.Stack;

public class Decryptor {

    private Decryptor() {
    }

    public static String decrypt(String cryptogram) {
        Stack<Character> cryptogramStack = deleteDuplicateCharacter(cryptogram);

        return decryptCharacterToString(cryptogramStack);
    }

    private static String decryptCharacterToString(Stack<Character> cryptogramStack) {
        StringBuilder decryptStringBuilder = new StringBuilder();

        for (Character character : cryptogramStack) {
            decryptStringBuilder.append(character);
        }
        return decryptStringBuilder.toString();
    }

    private static Stack<Character> deleteDuplicateCharacter(String cryptogram) {
        Stack<Character> cryptogramStack = new Stack<>();
        char[] cryptogramCharArray = cryptogram.toCharArray();

        cryptogramStack.push(cryptogramCharArray[CRYPTOGRAM_START_INDEX]);
        for (int i = CRYPTOGRAM_DUPLICATE_START_INDEX; i < cryptogram.length(); i++) {
            if (duplicateCharacter(cryptogramStack, cryptogramCharArray[i])) {
                cryptogramStack.pop();
                continue;
            }
            cryptogramStack.push(cryptogramCharArray[i]);
        }
        return cryptogramStack;
    }

    private static boolean duplicateCharacter(Stack<Character> cryptogramStack, Character target) {
        return !cryptogramStack.isEmpty() && cryptogramStack.peek() == target;
    }
}
