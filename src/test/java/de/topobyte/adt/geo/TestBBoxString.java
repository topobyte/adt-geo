package de.topobyte.adt.geo;

public class TestBBoxString
{

	public static void main(String[] args)
	{
		BBoxString box = BBoxString.parse("51.0,13,55.0,15.345345");
		System.out.println(box.lon1);
		System.out.println(box.lon2);
		System.out.println(box.lat1);
		System.out.println(box.lat2);
	}

}
