## https://www.acmicpc.net/problem/2217
k = int(input())
ropes = []
for _ in range(k):
    ropes.append(int(input()))

ropes = sorted(ropes,reverse=True)
answer = 0
for i in range(1,len(ropes)+1):
    temp = ropes[i-1] * i
    if temp > answer:
        answer = temp
print(answer)
