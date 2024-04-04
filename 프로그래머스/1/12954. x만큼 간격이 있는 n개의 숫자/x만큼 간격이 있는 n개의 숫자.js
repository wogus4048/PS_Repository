function solution(x, n) {
    var answer = [];
    
    for(let i =0;i<n;i++)
        {
            answer.push((i+1)*x);
        }
    
    const arr = Array(n).fill(x).map((value,index) => value*(index+1));
    console.log(arr);
    return answer;
}