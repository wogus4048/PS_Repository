T = int(input())

for _ in range(T):
  H,W,N= list(map(int,input().split()))
  a=(N//H)+1
  b=N%H
  if b==0 :
    b= H ; a -= 1 
  c=b*100+a
  print(c)