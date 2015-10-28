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

/**
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public class BBoxString
{

	/**
	 * lon1
	 */
	public double lon1;
	/**
	 * lon2
	 */
	public double lon2;
	/**
	 * lat1
	 */
	public double lat1;
	/**
	 * lat2
	 */
	public double lat2;

	/**
	 * parse a string in form "lon1,lat1,lon2,lat2"
	 * 
	 * @param string
	 *            the string to parse.
	 * 
	 * @return a BBoxString object filled with the read values.
	 */
	public static BBoxString parse(String string)
	{
		BBoxString bbox = new BBoxString();
		String[] splitted = string.split(",");
		if (splitted.length == 4) {
			bbox.lon1 = Double.valueOf(splitted[0]);
			bbox.lat1 = Double.valueOf(splitted[1]);
			bbox.lon2 = Double.valueOf(splitted[2]);
			bbox.lat2 = Double.valueOf(splitted[3]);
		}
		return bbox;
	}

	public static BBoxString create(BBox box)
	{
		BBoxString bbox = new BBoxString();
		bbox.lon1 = box.getLon1();
		bbox.lat1 = box.getLat1();
		bbox.lon2 = box.getLon2();
		bbox.lat2 = box.getLat2();
		return bbox;
	}

	@Override
	public String toString()
	{
		return String.format("%f,%f,%f,%f", lon1, lat1, lon2, lat2);
	}

	/**
	 * @return as BBox.
	 */
	public BBox toBbox()
	{
		return new BBox(lon1, lat1, lon2, lat2);
	}

}
