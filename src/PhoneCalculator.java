import java.util.Scanner;
import java.util.regex.Pattern;


public class PhoneCalculator {

    public static void main(String[] arg) {
        Pattern pattern1 = Pattern.compile("^(067|097|086|096|073|066|093|063|095)[0-9]{7}");
        Pattern pattern2 = Pattern.compile("^\\+38(067|097|086|096|073|066|093|063|095)[0-9]{7}");
        Pattern pattern3 = Pattern.compile("^0038(067|097|086|096|073|066|093|063|095)[0-9]{7}");
        System.out.println("Please enter the phone number:");
        while (true) {
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            if (s.equals("")) {
                break;
            }
            if (!pattern1.matcher(s).find() && !pattern2.matcher(s).find() && !pattern3.matcher(s).find()) {
                System.out.println("Phone number is incorrect. Please enter the phone number:");
                continue;
            }
            long sum = Long.valueOf(s);
            int i = 1;
            do {
                sum = summarize(sum, i);
                i++;
            } while (sum > 9);

        }

    }

    private static int summarize(Long numbers, int count) {
        int sum = 0;
        for (char c : String.valueOf(numbers).toCharArray()) {
            sum += c - '0';
        }
        System.out.println(count + " round of calculation is: " + sum);

        if(sum<10){
        switch (sum) {
            case 1:
                System.out.println("Final result is: one");
                break;
            case 2:
                System.out.println("Final result is: two");
                break;
            case 3:
                System.out.println("Final result is: three");
                break;
            case 4:
                System.out.println("Final result is: four");
                break;
            default:
                System.out.println("Final result is: " + sum);
            }
        }

        return sum;
    }





}


