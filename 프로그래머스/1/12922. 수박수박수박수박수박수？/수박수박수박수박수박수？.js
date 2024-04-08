function solution(n) {  
    let arr =['수','박']
    let result = '';
    for(let i=0;i<n;i++)
        {
            result += arr[i%2];
        }
    return result;
    
    
}