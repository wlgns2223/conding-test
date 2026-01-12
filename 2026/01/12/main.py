# https://www.acmicpc.net/problem/5525
n = int(input())
m = int(input())
s = input()

count = 0
pattern = 0
i = 0
while i < m -2:
    if s[i:i+3] == "IOI":
        pattern = 0

        while i < m -2 and s[i:i+3] == "IOI":
            pattern += 1

            if pattern >= n:
                count += 1

            i += 2
    else :
        i +=1

print(count)


