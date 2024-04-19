function solution(k, score) {
    var answer = [];
    var list = [];
    for(let num of score){
        list.push(num);
        list.sort((a,b)=>b-a);
        if(list.length <k){
            answer.push(list[list.length-1]);
        }else{
            answer.push(list[k-1]);
        }
        
    }
    
    return answer;
}