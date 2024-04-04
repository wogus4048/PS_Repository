function solution(s){
    var answer = true;

    
    
    const {p,y} =s.split('').reduce((acc,curr)=>{
        if(curr.toLowerCase() === 'p') {
            acc.p ++;
        }else if (curr.toLowerCase() ==='y')
            {
                acc.y++;
            }
        return acc;
        
    },{p:0,y:0})
    
    if(p !==y ) return false;


    return answer;
}