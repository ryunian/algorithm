package programmers;

import java.util.*;

class Song implements Comparable<Song> {
    int index;
    String genres;
    int plays;
    int max;

    public Song(int index, String genres, int play, int max) {
        this.index = index;
        this.genres = genres;
        this.plays = play;
        this.max = max;
    }

    @Override
    public int compareTo(Song o) {
        if (this.max < o.max ) {
            return 1;
        }else if(this.max > o.max){
            return -1;
        }else{
            if (this.plays < o.plays) {
                return 1;
            } else if (this.plays > o.plays) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}

    public class 베스트앨범 {
        public int[] solution(String[] genres, int[] plays) {
            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < genres.length; i++) {
                map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            }

            Song[] song = new Song[genres.length];
            for (int i = 0; i < genres.length; i++) {
                song[i] = new Song(i, genres[i], plays[i], map.get(genres[i]));
            }
            Arrays.sort(song);

            System.out.println();
            System.out.println(map);
            for (Song x : song) {
                System.out.println(x.index + " " + x.genres + " " + x.plays);
            }

            ArrayList<Integer> list = new ArrayList<>();
            int count = 0;
            list.add(song[0].index);
            for(int i=1; i<song.length;i++){
                if(song[i-1].genres.equals(song[i].genres)){
                    count++;
                }else{
                    count = 0;
                }
                if(count>=2){
                    continue;
                }
                list.add(song[i].index);
            }

            int[] answer = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }

            return answer;
        }

        public static void main(String[] args) {
//            String[] gennres = {"classic", "pop", "classic", "pop", "classic", "classic"};
            String[] gennres = {"classic", "pop", "classic", "classic", "pop", "z", "a", "a","pop"};
//            String[] gennres =  {"a", "b", "c", "d", "e", "f"};

//            int[] plays = {400, 600, 150, 2500, 500, 500};
            int[] plays = {500, 600, 150, 800, 2500, 100, 3000, 1,1};
//            int[] plays =  {1, 2, 3, 4, 5, 6};
            System.out.println(Arrays.toString(gennres));
            System.out.println(Arrays.toString(plays));
            베스트앨범 test = new 베스트앨범();
            int[] result = test.solution(gennres, plays);
            System.out.println();
            System.out.println(Arrays.toString(result));
        }
    }
