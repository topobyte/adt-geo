// Copyright 2015 Sebastian Kuerten
//
// This file is part of adt-geo.
//
// adt-geo is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// adt-geo is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with adt-geo. If not, see <http://www.gnu.org/licenses/>.

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
