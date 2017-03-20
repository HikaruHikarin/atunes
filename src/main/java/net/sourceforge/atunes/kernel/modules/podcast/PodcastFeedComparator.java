/*
 * aTunes
 * Copyright (C) Alex Aranda, Sylvain Gaudard and contributors
 *
 * See http://www.atunes.org/wiki/index.php?title=Contributing for information about contributors
 *
 * http://www.atunes.org
 * http://sourceforge.net/projects/atunes
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

package net.sourceforge.atunes.kernel.modules.podcast;

import java.io.Serializable;
import java.util.Comparator;

import net.sourceforge.atunes.model.IPodcastFeed;

final class PodcastFeedComparator implements Comparator<IPodcastFeed>, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3053627941518479804L;

	@Override
    public int compare(IPodcastFeed o1, IPodcastFeed o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
}