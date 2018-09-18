import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
    public static void main(String[] unused) {
        System.out.println(wordCount(urlToString("http://erdani.com/tdpl/hamlet.txt")));
        System.out.println(princeCounter(urlToString("http://erdani.com/tdpl/hamlet.txt")));
    }

    static int wordCount(String input) {
        String[] count = input.split("\\s");
        return count.length;
    }

    static int princeCounter(String input) {
        String[] count = input.split(" ");
        int counter = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i].equals("Prince") || count[i].equals("prince")) {
                counter++;
            }
        }
        return counter;
    }
}
