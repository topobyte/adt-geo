package de.topobyte.adt.geo;

import org.junit.Assert;
import org.junit.Test;

public class TestBBoxString
{

	@Test
	public void testParse()
	{
		BBoxString box = BBoxString.parse("51.0,13,55.0,15.345345");

		String asString = box.toString();
		BBoxString parsed = BBoxString.parse(asString);

		Assert.assertEquals(box.toBbox(), parsed.toBbox());
	}

	@Test
	public void testCreate()
	{
		BBox box = new BBox(51.0, 13, 55.0, 15.345345);

		BBoxString boxString = BBoxString.create(box);
		BBox created = boxString.toBbox();

		Assert.assertEquals(box, created);
	}

}
