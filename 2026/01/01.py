# https://www.acmicpc.net/problem/1373

n = input()

if len(n) % 3 == 1:
    n = "00" + n
elif len(n) % 3 == 2:
    n = "0" + n

m = {
    "000": "0",
    "001": "1",
    "010": "2",
    "011": "3",
    "100": "4",
    "101": "5",
    "110": "6",
    "111": "7"
}

l = []

for i in range(0,len(n),3):
    s = n[i:i+3]


    l.append(m[s])

answer = "".join(l)
print(answer)

