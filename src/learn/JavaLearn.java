package learn;

public class JavaLearn {
    public static void main(String[] args) {

        int num = 5;
        int people = 5;
        int sum = 0;

        for(int i = 0; i < num; i++){
            people = (int) Math.floor(people/2);
            sum += people;
            people *= 3;
        }


        System.out.println(sum);
    }
}
