# https://www.acmicpc.net/problem/1919
from collections import Counter

s1 = input()
s2 = input()

s1_count = Counter(s1)
s2_count = Counter(s2)
alphabets = "abcdefghijklmnopqrstuvwxyz"
count = 0

for c in alphabets:
    if c in s1 and c in s2:
        count += abs(s1_count[c] - s2_count[c])

    elif c in s1 and c not in s2:
        count += s1_count[c]

    elif c not in s1 and c in s2:
        count += s2_count[c]

print(count)







