function solution(a, b, n) {
    let empty=n;
    let result =0;
    
    while(empty>=a)
        {
            let value= parseInt(empty/a);
            let rest = empty%a;
            
            empty = value*b+rest;
            result += value*b;
        
        }
    return result;
}