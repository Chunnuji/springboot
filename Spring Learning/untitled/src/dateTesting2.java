import java.text.SimpleDateFormat;
import java.util.Date;

public class dateTesting2 {
    public static void main(String[] args) {
        Date date = new Date(); // Example date (current date and time)
        System.out.println(date);
        String formattedDate = formatDateWithoutTime(date);
        System.out.println("Formatted Date: " + formattedDate);
    }

    public static String formatDateWithoutTime(Date date) {
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
        return outputFormat.format(date);
    }
}
