N = int(input())
count=0

for _ in range(N):
  word = input()
  for i in range(len(word)):
    if i != len(word)-1:
      if word[i] == word[i+1]:
        pass
      elif word[i] in word[i+1:]:
        break
    else: count += 1
        
print(count)
