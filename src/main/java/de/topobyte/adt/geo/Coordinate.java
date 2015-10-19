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

/**
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public class Coordinate
{

	public double lon;
	public double lat;

	/**
	 * Create a new Coordinate.
	 * 
	 * @param lon
	 *            the longitude.
	 * @param lat
	 *            the latitude.
	 */
	public Coordinate(double lon, double lat)
	{
		this.lon = lon;
		this.lat = lat;
	}

	/**
	 * @return this coordinate's longitude.
	 */
	public double getLongitude()
	{
		return lon;
	}

	/**
	 * @return this coordinate's latitude.
	 */
	public double getLatitude()
	{
		return lat;
	}

	@Override
	public String toString()
	{
		return String.format("%f;%f", lon, lat);
	}

	/**
	 * Calculate the mean of this collection of coordinates.
	 * 
	 * @param coords
	 *            a collection of coordinates.
	 * @return the mean of the given coordinates.
	 */
	public static Coordinate mean(Collection<Coordinate> coords)
	{
		Coordinate m = new Coordinate(0.0, 0.0);
		for (Coordinate c : coords) {
			m.lon += c.lon;
			m.lat += c.lat;
		}
		m.lon /= coords.size();
		m.lat /= coords.size();
		return m;
	}

}
