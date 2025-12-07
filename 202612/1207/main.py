# https://www.acmicpc.net/problem/1026

N = int(input())
a = list(map(int,input().split(" ")))
input_b = list(map(int,input().split(" ")))
LIMIT = 101
b = [-1] * LIMIT
for k in input_b:
    b[k] = 1 if b[k] == -1 else b[k] + 1

a.sort()
i = 0
s = 0
for k in range(LIMIT-1,-1,-1):

    while b[k] > 0:
        s = s + (a[i] * k)
        i += 1
        b[k] -= 1


print(s)



