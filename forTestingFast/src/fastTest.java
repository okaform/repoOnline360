import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class fastTest {

    public static void main(String[] args) {
        String responded = "The username has already been taken.";
        String pattern = "already";
        Pattern r = Pattern.compile(pattern);

        Matcher m = r.matcher(responded);


        System.out.println(m.find());
        System.out.println(m.group(0));
    }
}
