import java.math.BigInteger;

public class RSA {

    public static void main(String[] args) {
        // Приклад параметрів RSA
        BigInteger p = new BigInteger("61");
        BigInteger q = new BigInteger("53");
        BigInteger n = p.multiply(q);
        BigInteger e = new BigInteger("17");
        BigInteger d = new BigInteger("413");

        // Зашифрування та розшифрування числа
        BigInteger number = new BigInteger("42");
        BigInteger encrypted = encrypt(number, e, n);
        BigInteger decrypted = decrypt(encrypted, d, n);

        System.out.println("Оригінальне число: " + number);
        System.out.println("Зашифроване число: " + encrypted);
        System.out.println("Розшифроване число: " + decrypted);
    }

    public static BigInteger encrypt(BigInteger number, BigInteger publicKey, BigInteger modulus) {
        // Застосовуємо модулярне піднесення до степеня: c = number^publicKey (mod modulus)
        BigInteger encrypted = number.modPow(publicKey, modulus);
        return encrypted;
    }

    public static BigInteger decrypt(BigInteger encrypted, BigInteger privateKey, BigInteger modulus) {
        // Застосовуємо модулярне піднесення до степеня: number = encrypted^privateKey (mod modulus)
        BigInteger decrypted = encrypted.modPow(privateKey, modulus);
        return decrypted;
    }
}
