package challenge;

public class CriptografiaCesariana implements Criptografia {

    @Override
    public String criptografar(String texto) {

        if(texto.isEmpty()) {
            throw new IllegalArgumentException();
        }

        String messageTolowerCase = texto.toLowerCase();
        StringBuilder encryptedText = new StringBuilder();
        int displacement = 3;

        for(int i = 0; i < messageTolowerCase.length(); i++) {

            // ignores all non-alphabet characters in lower case
            if(messageTolowerCase.codePointAt(i) < 97 || messageTolowerCase.codePointAt(i) > 122) {

                encryptedText.append(messageTolowerCase.charAt(i));

            } else {
                // Get the ASCII code regarding to your dencrypted position (three positions displacement)
                int getASCIICode = ((messageTolowerCase.codePointAt(i) - 97 + displacement) % 26) + 97;

                encryptedText.append((char) getASCIICode);
            }
        }

        return encryptedText.toString();

    }

    @Override
    public String descriptografar(String texto) {

        if(texto.isEmpty()) {
            throw new IllegalArgumentException();
        }

        String messageTolowerCase = texto.toLowerCase();
        StringBuilder decryptedText = new StringBuilder();
        int reverseDisplacement = -3;

        for(int i = 0; i < messageTolowerCase.length(); i++) {

            // ignores all non-alphabet characters in lower case
            if(messageTolowerCase.codePointAt(i) < 97 || messageTolowerCase.codePointAt(i) > 122) {

                decryptedText.append(messageTolowerCase.charAt(i));

            } else {
                // Get the ASCII code regarding to your encrypted position (three positions displacement)
                int getASCIICode = ((messageTolowerCase.codePointAt(i) - 97 + reverseDisplacement) % 26) + 97;

                decryptedText.append((char) getASCIICode);
            }
        }

        return decryptedText.toString();

    }

}
