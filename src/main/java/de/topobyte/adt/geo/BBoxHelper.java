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

import java.util.Collection;
import java.util.Iterator;

public class BBoxHelper
{

	public static BBox minimumBoundingBox(Coordinate... coordinates)
	{
		if (coordinates.length == 0) {
			return null;
		}
		BBox bbox = new BBox(0, 0, 0, 0);
		minimumBoundingBox(bbox, coordinates);
		return bbox;
	}

	public static void minimumBoundingBox(BBox bbox, Coordinate... coordinates)
	{
		Coordinate c = coordinates[0];

		double minLat = c.getLatitude();
		double maxLat = c.getLatitude();
		double minLon = c.getLongitude();
		double maxLon = c.getLongitude();

		final int len = coordinates.length;
		for (int i = 1; i < len; i++) {
			c = coordinates[i];
			final double lon = c.lon;
			if (lon < minLon) {
				minLon = lon;
			}
			if (lon > maxLon) {
				maxLon = lon;
			}
			final double lat = c.lat;
			if (lat < minLat) {
				minLat = lat;
			}
			if (lat > maxLat) {
				maxLat = lat;
			}
		}

		bbox.set(minLon, maxLat, maxLon, minLat);
	}

	public static BBox minimumBoundingBox(Collection<Coordinate> coordinates)
	{
		if (coordinates.size() == 0) {
			return null;
		}
		BBox bbox = new BBox(0, 0, 0, 0);
		minimumBoundingBox(bbox, coordinates);
		return bbox;
	}

	public static BBox minimumBoundingBox(BBox bbox,
			Collection<Coordinate> coordinates)
	{
		Coordinate c = coordinates.iterator().next();

		double minLat = c.getLatitude();
		double maxLat = c.getLatitude();
		double minLon = c.getLongitude();
		double maxLon = c.getLongitude();

		Iterator<Coordinate> iterator = coordinates.iterator();
		while (iterator.hasNext()) {
			c = iterator.next();
			final double lon = c.lon;
			if (lon < minLon) {
				minLon = lon;
			}
			if (lon > maxLon) {
				maxLon = lon;
			}
			final double lat = c.lat;
			if (lat < minLat) {
				minLat = lat;
			}
			if (lat > maxLat) {
				maxLat = lat;
			}
		}

		return new BBox(minLon, maxLat, maxLon, minLat);
	}

	public static void scaleByFactor(BBox box, double factor)
	{
		double lon1 = box.getLon1();
		double lon2 = box.getLon2();
		double lat1 = box.getLat1();
		double lat2 = box.getLat2();
		double width = lon2 - lon1;
		double height = lat1 - lat2;
		double dLon = (factor - 1) / 2 * width;
		double dLat = (factor - 1) / 2 * height;
		box.set(lon1 - dLon, lat1 + dLat, lon2 + dLon, lat2 - dLat);
	}

}
