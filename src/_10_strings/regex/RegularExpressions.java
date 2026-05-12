package _10_strings.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegularExpressions {
    public static void main(String[] args) {
        System.out.println("Some string literal".replaceAll("(?i)s", "x"));

        Pattern pattern = Pattern.compile("s", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("This is another String literal");
        String result = matcher.replaceAll("x");
        System.out.println(result);


        // Requires Java >= 15
        String text = """
                Here we have text that has custom {variable} templates?

                Also, it spans multiple lines {neat!}.
                """;
        Pattern pattern2 = Pattern.compile("\\{(.+?)\\}");
        Matcher matcher2 = pattern2.matcher(text);
        String result2 = matcher2.replaceAll(m -> {
            return "[v:" + m.group(1) + "]";
        });
        System.out.println(result2);
    }
}
