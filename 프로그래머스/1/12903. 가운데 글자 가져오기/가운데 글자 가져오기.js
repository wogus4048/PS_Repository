function solution(s) {
    return s.length%2 !=0 ? s.slice(Math.floor(s.length/2),Math.floor(s.length/2)+1) :
        s.slice(s.length/2-1,s.length/2+1);
}