/*
 * This file is part of Apparat.
 *
 * Apparat is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Apparat is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Apparat. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (C) 2009 Joa Ebert
 * http://www.joa-ebert.com/
 *
 */
package apparat.taas.backend.jbc

import java.lang.String

/**
 * @author Joa Ebert
 */
class JbcClassLoader(map: Map[String, Array[Byte]]) extends ClassLoader {
	override protected def findClass(name: String): Class[_] = {
		println("findClass: "+name)
		(map get name) match {
			case Some(result) => defineClass(name, result, 0, result.length)
			case None => super.findClass(name)
		}
	}
}