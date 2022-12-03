

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> numbersMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        int sum =0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int maxTimes =0;
        List<Integer> maxTimeValues = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int inputNumber = Integer.parseInt(br.readLine());
            if (numbersMap.containsKey(inputNumber)) {
                numbersMap.put(inputNumber, numbersMap.get(inputNumber) + 1);
            }
            else{
                numbersMap.put(inputNumber, 1);
            }
            sum += inputNumber;
            if (max < inputNumber) {
                max = inputNumber;
            }
            if (min > inputNumber) {
                min = inputNumber;
            }
        }

        List<Integer> numberList = new ArrayList<>();



        for (Entry<Integer, Integer> entry : numbersMap.entrySet()) {
            int currentValue = entry.getValue();
            int currentKey = entry.getKey();
            while (currentValue > 0) {
                numberList.add(currentKey);
                currentValue--;
            }
        }

        Collection<Integer> values = numbersMap.values();
        List<Integer> valueList = new ArrayList<>(values);
        valueList.sort(Comparator.naturalOrder());
        maxTimes = valueList.get(valueList.size() - 1);

        for (Entry<Integer, Integer> entry : numbersMap.entrySet()) {
            int currentValue = entry.getValue();
            int currentKey = entry.getKey();
            if (maxTimes == currentValue) {
                maxTimeValues.add(currentKey);
            }
        }

        maxTimeValues.sort(Comparator.naturalOrder());


        numberList.sort(Comparator.naturalOrder());



        sb.append((int)Math.round((double)sum/n)  + "\n");
        sb.append(numberList.get(n / 2) + "\n");
        if (maxTimeValues.size() > 1) {
            sb.append(maxTimeValues.get(1) + "\n");
        }
        else{
            sb.append(maxTimeValues.get(0) + "\n");
        }

        sb.append(max - min + "\n");

        bw.write(sb.toString());


        bw.flush();
        bw.close();
    }
}
