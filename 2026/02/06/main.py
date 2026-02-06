# https://www.acmicpc.net/problem/2224

n = int(input())
ALPHA_NUM = 52
graph = [[0] * ALPHA_NUM for _ in range(ALPHA_NUM)]

def convert_to_num(alpha):
    if ord(alpha) <= ord('Z'):
        return ord(alpha) - ord('A')
    else:
        return ord(alpha)  -ord('a') + 26

def convert_to_char(num):
    if num <= 25:
        return chr(num + ord('A'))
    else:
        return chr(num + ord('a') - 26)

for _ in range(n):
    a,_,b = input().split(" ")
    a,b = convert_to_num(a),convert_to_num(b)
    graph[a][b] = 1

answer = []
for a in range(ALPHA_NUM):
    for b in range(ALPHA_NUM):
        if graph[a][b]:
            answer.append((a,b))

for k in range(ALPHA_NUM):
    for a in range(ALPHA_NUM):
        for b in range(ALPHA_NUM):
            if graph[a][k] and graph[k][b]:
                graph[a][b] = 1
                answer.append((a,b))


answer = sorted(answer)

print(len(set(answer)))
for a,b in answer:
    if a == b:
        continue
    a,b = convert_to_char(a),convert_to_char(b)
    print(f"{a} => {b}")