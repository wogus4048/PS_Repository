a=input().split()
for i in range(len(a)):
  a[i] = a[i][::-1]

print(max(a))