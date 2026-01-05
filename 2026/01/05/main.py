def is_prime(n):
    if n == 1:
        return True

    for i in range(2, int(n ** 0.5)+1):
        if n % i == 0:
            return False

    return True

s = input()
count = 0
for c in s:
    ret = 0
    if ord(c) < ord('a'):
        ret += 26
        c = c.lower()
    ret += (ord(c) - ord('a')) + 1
    count += ret

print("It is a prime word." if is_prime(count) else "It is not a prime word.")

