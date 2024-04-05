function solution(arr) {
    
    let min = 0;
    arr.forEach((v,index) => min = arr[min] > v ? index: min);
    arr.splice(min,1);
    return arr.length==0 ? [-1] : arr;

}