import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.HashMap;
import java.util.Map;

public class UrlShortner {
	private String domain;
	private int lengthOfShortUrl;
	private Map<String, String> shortToLongUrlMap; // short url is key
	private Map<String, String> longToShortUrlMap; // long to short url mapping / long url is mapping
	private ArrayList<Character> allowedChars;

	public UrlShortner(String domain, int lengthOfShortUrl) {
		super();
		this.domain = domain;
		this.lengthOfShortUrl = lengthOfShortUrl;

		this.shortToLongUrlMap = new HashMap<>();
		this.longToShortUrlMap = new HashMap<>();

		this.allowedChars = new ArrayList<>();

		for (char i = 'a'; i < 'z'; i++) {
			this.allowedChars.add(i);
		}

		for (char i = 'A'; i < 'Z'; i++) {
			this.allowedChars.add(i);
		}

		for (char i = '0'; i < '9'; i++) {
			this.allowedChars.add(i);
		}

	}

	public String shortenUrl(String longUrl) {

		if (longUrl.length() <= lengthOfShortUrl)
			return longUrl;

		if (longToShortUrlMap.containsKey(longUrl)) {
			return longToShortUrlMap.get(longToShortUrlMap);
		}

		String shortUrl = this.domain + "/";

		while (true) {
			for (int i = 0; i < this.lengthOfShortUrl; i++) {
				Random random = new Random();
				int index = random.nextInt(62);
				char ch = this.allowedChars.get(index);
				shortUrl += ch;

			}

			if (!shortToLongUrlMap.containsKey(shortUrl)) {
				break;
			}

		}
		shortToLongUrlMap.put(shortUrl, longUrl);// given a long url,you need to short url
		longToShortUrlMap.put(longUrl, shortUrl);

		return shortUrl;
	}

	public String expandUrl(String shortUrl) throws Exception {
		if (shortToLongUrlMap.containsKey(shortUrl)) {
			return shortToLongUrlMap.get(shortUrl);
		}
		throw new Exception("No ShortUrl found");
	}

	public static void main(String[] args) {

		UrlShortner url = new UrlShortner("abc.com", 5);
		
		

		System.out.println("shorten url is = " + url.shortenUrl("www.himanshu.com") + " for " + "www.himanshu.com");

	}

}
