import java.util.*;
import java.util.Map.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String,List<Music>> map = new HashMap<>(); // <카테고리, List<Music객체>>
        Map<String,Integer> map2 = new HashMap<>(); // <카테고리, 총재생횟수>>
        
        for(int i=0;i<genres.length;i++)
        {
            String genre = genres[i];
            int count = plays[i];
            
            if(!map.containsKey(genre)) //초기화 부분
            {
                map.put(genre,new ArrayList<>());
                map2.put(genre,0);
            }
            
            map.get(genre).add(new Music(i,count)); // map의 리스트에 Music 추가
            map2.put(genre,map2.get(genre)+count); // map2에는 총횟수 증가
        }
        //map2의 entrySet을 이용하여 총갯수를 기준으로 내림차순 정렬
        
        List<Entry<String,Integer>> list2 = new ArrayList<>(map2.entrySet());
        
        list2.sort((o1,o2) -> {
           return map2.get(o2.getKey()) - map2.get(o1.getKey()) ; 
        });
        // 결과 -> 총갯수가 높은순서대로 entry가 정리됨
        // System.out.println(list2.toString());
        
        
        //map안의 List<Music>을 재생횟수 기준으로 정렬
        for(String category : map.keySet())
        {
            List<Music> currentList = map.get(category);
            currentList.sort((o1,o2) -> {
                return o2.count - o1.count;
            });
        }
        //결과 -> 각 List마다 Music의 count수를 기준으로 정렬된다.
        
        List<Integer> answerList = new ArrayList<>();
        for(Entry<String,Integer> entry : list2)
        {
            String category = entry.getKey(); //총 재생횟수가 높은 장르부터 하나씩 가져와서
            //장르를 이용해서 해당 장르의 음악중 재생횟수가 높은 음악의 인덱스를 최대 2개씩 넣는다.
            List<Music> musicList = map.get(category);
            int musicIndex = musicList.get(0).index;
            answerList.add(musicIndex) ;
            if(musicList.size() != 1)
            {
                int musicIndex2 = musicList.get(1).index;
                answerList.add(musicIndex2) ;
            }
            
        }
        int[] answer = new int[answerList.size()];
        for(int i=0;i<answer.length;i++)
        {
            answer[i] = answerList.get(i);
        }
        
    
        return answer;

    }
    
    class Music{
        int index; // 고유번호
        int count=0; // 재생횟수
        
        public Music(int index,int count)
        {
            this.index = index;
            this.count = count;
        }
        
        public Music(int index)
        {
            this.index = index;
        }
        
        public void addCount(int count)
        {
            this.count += count;
        }
    }
}

/*
--- 틀린풀이 ---
장르별 총 재생횟수를 알아야하고
장르 속에서 각 노래의 재생횟수 큰순서대로 알고있어야한다.

Map<String,Map<Integer,Integer>>를 이용해보자.
안쪽 Map에서 key값 -1에는 카테고리 총 재생횟수, 나머지는 키 : 인덱스 밸류 :재생횟수
겉의 Map은 <카테고리,Map>으로 되어있고
안쪽 Map은 value를 기준으로 내림차순 정렬
겉의 Map에서 안쪽Map의 키 :-1의 값 (장르별 총 재생횟수)를 이용해서 정렬

한후 겉의 Map에서 2개씩 뽑아내면된다.

Map은 정렬이 안되므로 List를 이용한다.

--- 수정된 풀이 ---
안쪽의 Map<Integer,Integer>를 만들지말고 
객체변수로 int,int를 가지는 새로운 객체로 생성해서 만든다.

총갯수는 따로 빼서 만들어둔다.
하나의 Map안에서 모두 처리하려고하지말자.



*/