public class Main {
    public static void main(String[] args) {
        ClockDisplay clockDisplay = new ClockDisplay(12, 59, 50);
        while(true) {
            System.out.println(clockDisplay.getTime());
            try {
                Thread.sleep(1000);
            }
            catch (Exception e) {
                System.out.println(e);
            }
            clockDisplay.timeTick();
        }
    }
}