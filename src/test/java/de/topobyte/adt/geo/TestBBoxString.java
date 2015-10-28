package de.topobyte.adt.geo;

import org.junit.Assert;
import org.junit.Test;

public class TestBBoxString
{

	@Test
	public void test()
	{
		BBoxString box = BBoxString.parse("51.0,13,55.0,15.345345");

		String asString = box.toString();
		BBoxString parsed = BBoxString.parse(asString);

		Assert.assertEquals(box.toBbox(), parsed.toBbox());
	}

}
