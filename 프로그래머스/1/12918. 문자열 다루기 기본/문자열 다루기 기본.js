function solution(s) {
    let result = true;
    if(s.length ==4 || s.length ==6)
        {
            [...s].forEach((value) => {
        if(isNaN(value/1)){
            result = false;
            return;
        }
    })
        }
    else{return false;
}
    
        
    
    
    if(result) return true;
    else return false;
}