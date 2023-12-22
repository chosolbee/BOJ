import sys
from collections import Counter

def avg(arr, n):
    return (round(sum(arr)/n))

def mid(arr, n):
    return arr[n//2]

def max(arr, n):
    max = Counter(arr).most_common()
    if len(max) > 1 and max[0][1]==max[1][1]:
        return max[1][0]
    else:
        return max[0][0]

def numrange(arr, n):
    cha=arr[-1]-arr[0]
    return cha

n=int(input())
number=[]
for _ in range(n):
    number.append(int(sys.stdin.readline()))
number.sort()

print(avg(number,n))
print(mid(number,n))
print(max(number,n))
print(numrange(number,n))

