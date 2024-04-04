function solution(numbers) {
    var answer = 0;
    
    const arr = Array(10).fill(false);
    
    numbers.forEach((v) => arr[v] = true);
    console.log(arr);
    for(let i =0;i<10;i++)
        {
            if(!arr[i]) answer +=i;
        }
    
    return answer;
}