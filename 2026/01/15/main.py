# https://www.acmicpc.net/problem/2469

k = int(input())
n = int(input())
result = list(input())
ladders = []

people = [chr(ord('A')+ i) for i in range(k)]
answer = ["*" for _ in range(k-1)]

hidden = "?" * (k-1)
first_ladders = []
second_ladders = []
for _ in range(n):
    ladder = input()
    if ladder == hidden:
        first_ladders = second_ladders
        second_ladders = []
        continue

    second_ladders.append(ladder)


for ladder in first_ladders:
    for key,v in enumerate(ladder):

        if v == "-":
            people[key],people[key+1] = people[key+1],people[key]

for ladder in reversed(second_ladders):
    for key,v in enumerate(ladder):
        if v == "-":
            result[key], result[key+1] = result[key+1], result[key]

for i in range(k-1):

    # if people[i] == result[i] or people[i+1] == result[i+1]:
    #     answer[i] = "*"
    if people[i] == result[i+1] and people[i+1] == result[i]:
        answer[i] = "-"
        people[i],people[i+1] = people[i+1],people[i]

if people != result:
    answer = ['x' for _ in range(k-1)]

print("".join(answer))







