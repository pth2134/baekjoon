import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class Main {
	public static void main(String[] args)
	{
		StringBuilder sb = new StringBuilder();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		String[] date = simpleDateFormat.format(Calendar.getInstance().getTime()).split("-");
		sb.append(date[0]).append('\n');
		sb.append(date[1]).append('\n');
		sb.append(date[2]).append('\n');

		System.out.println(sb);
	}
}
