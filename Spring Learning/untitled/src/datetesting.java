import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class datetesting {
    public static void main(String[] args) {
        String inputDate = "23/02/2000 12:12:00";
        String outputDate = formatDateWithoutTime(inputDate);
        System.out.println("Formatted Date: " + outputDate);
        Date d = stringToDate(outputDate);
        System.out.println("------------------------");
        System.out.println(d);
        System.out.println("------------------------");
    }

    public static Date stringToDate(String dateStr) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false); // Strict parsing to ensure valid dates

        try {
            return format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null; // Return null if parsing fails
        }
    }

    public static String formatDateWithoutTime(String dateStr) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = null;

        try {
            Date date = inputFormat.parse(dateStr);
            formattedDate = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return formattedDate;
    }
}
