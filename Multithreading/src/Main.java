
// from https://link.springer.com/chapter/10.1007/978-1-4842-7135-3_5

public class Main {

    public static int counter = 1;

    public static void main(String[] args) {

        for ( int counter = 0; counter < 1000; counter ++ ){
            Thread thread = new Thread(Main::print);
            thread.start();
        }
    }
    public static void print() {
        for (int i = 1; i <= 500; i++) {
            counter += 1;
            System.out.println(counter);
        }
    }
}