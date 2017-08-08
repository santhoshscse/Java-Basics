package common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author santhoshsrinivasan
 *
 */
public class SortPhoto {
	public static void main(String[] args) {
		String s = "photo.jpg, Warsaw, 2013-09-05 14:08:15\njohn.png, London, 2015-06-20 15:13:22\nmyFriends.png, Warsaw, 2013-09-05 14:07:13\nEiffel.jpg, Paris, 2015-07-23 08:03:02\npisatower.jpg, Paris, 2015-07-22 23:59:59\nBOB.jpg, London, 2015-08-05 00:02:03\nnotredame.png, Paris, 2015-09-01 12:00:00\nme.jpg, Warsaw, 2013-09-06 15:40:22\na.png, Warsaw, 2016-02-13 13:33:50\nb.jpg, Warsaw, 2016-01-02 15:12:22\nc.jpg, Warsaw, 2016-01-02 14:34:30\nd.jpg, Warsaw, 2016-01-02 15:15:01\ne.png, Warsaw, 2016-01-02 09:49:09\nf.png, Warsaw, 2016-01-02 10:55:32\ng.jpg, Warsaw, 2016-02-29 22:13:11";
		System.out.println("output==" + solution(s));
	}

	public static String solution(String S) {
		String[] lineArr = S.split("\n");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		class PhotoEntry {
			int entryNo;
			String name;
			String city;
			long date;
			String newName;

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public String getCity() {
				return city;
			}

			public void setCity(String city) {
				this.city = city;
			}

			public long getDate() {
				return date;
			}

			public void setDate(long l) {
				this.date = l;
			}

			public int getEntryNo() {
				return entryNo;
			}

			public void setEntryNo(int entryNo) {
				this.entryNo = entryNo;
			}

			public String getNewName() {
				return newName;
			}

			public void setNewName(String newName) {
				this.newName = newName;
			}

			@Override
			public String toString() {
				StringBuilder builder = new StringBuilder();
				builder.append("PhotoEntry [entryNo=");
				builder.append(entryNo);
				builder.append(", name=");
				builder.append(name);
				builder.append(", city=");
				builder.append(city);
				builder.append(", date=");
				builder.append(date);
				builder.append(", newName=");
				builder.append(newName);
				builder.append("]");
				return builder.toString();
			}

		}

		HashMap<String, Integer> cityCount = new HashMap<String, Integer>();

		HashMap<Integer, PhotoEntry> entryMap = new HashMap<Integer, PhotoEntry>(lineArr.length);
		for (int i = 0; i < lineArr.length; i++) {
			try {
				PhotoEntry en = new PhotoEntry();
				String[] entryArr = lineArr[i].split(",");
				en.setEntryNo(i);
				en.setName(entryArr[0].trim());
				String city = entryArr[1].trim();
				en.setCity(city);
				String dateStr = entryArr[2].trim();
				Date parsedDate = df.parse(dateStr);
				System.out.println(parsedDate);
				en.setDate(parsedDate.getTime());
				entryMap.put(i, en);
				addToCity(cityCount, city);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		HashMap<String, Integer> noOfDigitCityCount = new HashMap<String, Integer>();
		for (String str : cityCount.keySet()) {
			int digit = getDigit(cityCount.get(str));
			noOfDigitCityCount.put(str, digit);
		}
		Map<Integer, PhotoEntry> result = new LinkedHashMap<Integer, PhotoEntry>();
		for (String city : cityCount.keySet()) {
			HashMap<Integer, PhotoEntry> tmpMap = new HashMap<Integer, PhotoEntry>(cityCount.get(city));
			for (Integer no : entryMap.keySet()) {
				if (entryMap.get(no).getCity().equals(city)) {
					tmpMap.put(no, entryMap.get(no));
				}
			}

			List<Map.Entry<Integer, PhotoEntry>> list = new LinkedList<Map.Entry<Integer, PhotoEntry>>(
					tmpMap.entrySet());
			Collections.sort(list, new Comparator<Map.Entry<Integer, PhotoEntry>>() {
				public int compare(Map.Entry<Integer, PhotoEntry> o1, Map.Entry<Integer, PhotoEntry> o2) {
					System.out.println(
							o1.getValue().getName() + " " + o1.getValue().getCity() + " " + o1.getValue().getDate());
					System.out.println(
							o1.getValue().getName() + "" + o2.getValue().getCity() + " " + o2.getValue().getDate());
					if(o1.getValue().getDate() > o2.getValue().getDate()){
						return 1;
					}else if(o1.getValue().getDate() < o2.getValue().getDate()){
						return -1;
					}else{
						return 0;
					}
				}
			});

			HashMap<String, Integer> tmpCityCount = new HashMap<String, Integer>();

			for (Map.Entry<Integer, PhotoEntry> entry : list) {
				String no = getCityCount(tmpCityCount, entry.getValue().getCity(), noOfDigitCityCount,
						entry.getValue().getName());
				entry.getValue().setNewName(no);
				result.put(entry.getKey(), entry.getValue());
				System.out.println(entry.getKey() + "" + no);
			}
		}

		StringBuilder sb = new StringBuilder();
		int i = 0;
		for (i = 0; i < lineArr.length - 1; i++) {
			sb.append(result.get(i).getNewName()).append("\n");
		}
		sb.append(result.get(i).getNewName());
		return sb.toString();
	}

	/**
	 * @param tmpCityCount
	 * @param city
	 * @param noOfDigitCityCount
	 * @param name
	 * @return
	 */
	private static String getCityCount(HashMap<String, Integer> tmpCityCount, String city,
			HashMap<String, Integer> noOfDigitCityCount, String name) {
		Integer currCount = tmpCityCount.get(city);
		if (currCount == null) {
			currCount = 1;
			tmpCityCount.put(city, currCount);
		} else {
			currCount = currCount.intValue() + 1;
			tmpCityCount.put(city, currCount);
		}

		int tmpDigitCount = getDigit(currCount);

		String retVal = currCount + "";
		for (int i = 1; i <= noOfDigitCityCount.get(city) - tmpDigitCount; i++) {
			retVal = "0" + retVal;
		}
		String ext = name.substring(name.lastIndexOf('.'));
		return city + retVal + ext;
	}

	/**
	 * @param integer
	 * @return
	 */
	private static int getDigit(Integer integer) {
		int count = 0;
		while (integer > 0) {
			integer = integer / 10;
			count++;
		}
		return count;
	}

	/**
	 * @param cityCount
	 * @param city
	 */
	private static void addToCity(HashMap<String, Integer> cityCount, String city) {
		Integer val = cityCount.get(city);
		if (val != null) {
			cityCount.put(city, val.intValue() + 1);
		} else {
			cityCount.put(city, 1);
		}
	}
}
