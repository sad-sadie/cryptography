# cryptography
Перший код реалізує алгоритм Діффі-Хеллмана для обміну секретними ключами між двома сторонами. Алгоритм Діффі-Хеллмана використовує математичні операції на великих числах для створення загального секретного ключа, який використовується для шифрування та розшифрування повідомлень.

Алгоритм працює наступним чином:

Обираються два загальні числа: просте число (prime) і база (base). У цьому прикладі використовуються значення 23 і 5 відповідно.

Кожна сторона (Аліса і Боб) обирає випадкове приватне число (privateKey), яке є великим випадковим числом меншим за prime. В цьому коді функція generatePrivateKey() генерує випадкове приватне число для заданого prime.

Кожна сторона обчислює публічний ключ (publicKey) на основі бази, простого числа і свого приватного ключа. Функція generatePublicKey() обчислює публічний ключ шляхом піднесення бази до степеня приватного ключа і обчислення залишку від ділення на prime.

Кожна сторона обмінюється публічним ключем з іншою стороною.

Кожна сторона обчислює спільний секретний ключ (sharedSecret) на основі отриманого публічного ключа, простого числа і свого приватного ключа. Функція computeSharedSecret() обчислює спільний секретний ключ шляхом піднесення публічного ключа до степеня приватного ключа і обчислення залишку від ділення на prime.

На кожній стороні перевіряється, чи збігаються обчислені спільні секретні ключі. Якщо так, це означає, що сторони успішно обмінялися секретним ключем.

У цьому коді виводяться публічний ключ Аліси, публічний ключ Боба, спільний секретний ключ Аліси, спільний секретний ключ Боба та прапорець, який показує, чи збігаються спільні секретні ключі.

Другий код реалізує алгоритм RSA для шифрування та розшифрування повідомлень з використанням великих чисел. Алгоритм RSA базується на математичній проблемі факторизації та використовує два простих числа p і q, а також публічний та приватний ключі.

У цьому коді використовуються наступні значення:

p = 61 - перше просте число
q = 53 - друге просте число
n = p * q - модуль, що отримується добутком p і q
e = 17 - публічна експонента, яка взаємно проста з (p-1) * (q-1)
d = 413 - приватна експонента, яка обчислюється як обернена до e за модулем (p-1) * (q-1)
Алгоритм RSA працює наступним чином:

Генерація ключів:

Обираються два великі прості числа p і q.
Обчислюється модуль n, який є добутком p і q: n = p * q.
Обирається публічна експонента e, яка є цілим числом і взаємно проста з (p-1) * (q-1).
Обчислюється приватна експонента d, яка є оберненою до e за модулем (p-1) * (q-1): d ≡ e^(-1) (mod (p-1) * (q-1)).
Публічний ключ: (e, n).
Приватний ключ: (d, n).
Шифрування:

Повідомлення, яке потрібно зашифрувати, представляється у вигляді цілого числа m, де 0 ≤ m < n.
Застосовується модулярне піднесення до степеня: c ≡ m^e (mod n).
Зашифроване повідомлення: c.
Розшифрування:

Зашифроване повідомлення c представляється у вигляді цілого числа.
Застосовується модулярне піднесення до степеня: m ≡ c^d (mod n).
Розшифроване повідомлення: m.
В нашому коді виводяться початкове число, зашифроване число та розшифроване число.




