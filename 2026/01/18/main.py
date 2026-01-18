first = input()
second = input()

basic_num = {'I': 1,"II":2,"III":3, 'V': 5, 'X': 10,"XX":20,
             "XXX":30,'L': 50, 'C': 100,"CC":200,"CCC":300,
             'D': 500, 'M': 1000,"MM":2000,"MMM":3000}
bonus_num = {'IV': 4,'IX': 9,'XL': 40,'XC': 90,'CD': 400,'CM': 900 }

def convert_to_num(target):
    i = 0
    total = 0
    while i < len(target):
        if i < len(target) - 1 and target[i:i + 2] in bonus_num.keys():
            key = target[i:i + 2]
            total += bonus_num[key]
            i += 2
            continue
        key = target[i]
        total += basic_num[key]
        i += 1
    return total

total_sum = convert_to_num(first) + convert_to_num(second)



nums = list(basic_num.items()) + list(bonus_num.items())

total_str = ""
total_sum_num = total_sum
while total_sum:
    temp_k, temp_v = "", 0
    for k,v in nums:
        if total_sum - v < 0:
            continue

        if total_sum - v < total_sum - temp_v:
            temp_k = k
            temp_v = v

    total_sum -= temp_v
    total_str += temp_k


print(total_sum_num)
print(total_str)








