import java.math.BigInteger;
import java.security.SecureRandom;

public class DiffieHellman {

    public static void main(String[] args) {
        // Спільне просте число та база
        BigInteger prime = new BigInteger("23");
        BigInteger base = new BigInteger("5");

        // Приватний ключ Аліси
        BigInteger alicePrivateKey = generatePrivateKey(prime);

        // Приватний ключ Боба
        BigInteger bobPrivateKey = generatePrivateKey(prime);

        // Публічний ключ Аліси
        BigInteger alicePublicKey = generatePublicKey(base, prime, alicePrivateKey);

        // Публічний ключ Боба
        BigInteger bobPublicKey = generatePublicKey(base, prime, bobPrivateKey);

        // Обчислення спільного секретного ключа
        BigInteger aliceSharedSecret = computeSharedSecret(bobPublicKey, prime, alicePrivateKey);
        BigInteger bobSharedSecret = computeSharedSecret(alicePublicKey, prime, bobPrivateKey);

        // Перевірка, чи співпадають спільні секретні ключі
        boolean sharedSecretsMatch = aliceSharedSecret.equals(bobSharedSecret);

        System.out.println("Публічний ключ Аліси: " + alicePublicKey);
        System.out.println("Публічний ключ Боба: " + bobPublicKey);
        System.out.println("Спільний секретний ключ Аліси: " + aliceSharedSecret);
        System.out.println("Спільний секретний ключ Боба: " + bobSharedSecret);
        System.out.println("Спільні секретні ключі співпадають: " + sharedSecretsMatch);
    }

    public static BigInteger generatePrivateKey(BigInteger prime) {
        SecureRandom random = new SecureRandom();
        BigInteger privateKey;

        do {
            privateKey = new BigInteger(prime.bitLength(), random);
        } while (privateKey.compareTo(BigInteger.ONE) <= 0 || privateKey.compareTo(prime.subtract(BigInteger.ONE)) >= 0);

        return privateKey;
    }

    public static BigInteger generatePublicKey(BigInteger base, BigInteger prime, BigInteger privateKey) {
        // Обчислення публічного ключа: publicKey = (base ^ privateKey) % prime
        return base.modPow(privateKey, prime);
    }

    public static BigInteger computeSharedSecret(BigInteger publicKey, BigInteger prime, BigInteger privateKey) {
        // Обчислення спільного секретного ключа: sharedSecret = (publicKey ^ privateKey) % prime
        return publicKey.modPow(privateKey, prime);
    }
}
