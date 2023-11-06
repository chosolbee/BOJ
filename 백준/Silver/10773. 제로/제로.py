class Stack:
    def __init__(self, size):
        self.top=-1
        self.stack=[]
        self.size=size

    def push(self,item):
        if self.top < (self.size-1):
            self.top += 1
            self.stack.append(item)
        else: return
        
    def pop(self):
        if self.top > -1:
            self.top -=1
            return self.stack.pop()
        else: return

n=int(input())
s=Stack(n)
sum=0
for i in range(n):
    num=int(input())
    s.push(num)
    sum+=num
    if num==0:
        s.pop()
        sum-=s.pop()
print(sum)