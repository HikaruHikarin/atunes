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

package net.sourceforge.atunes.kernel.modules.playlist;

import java.util.ArrayList;
import java.util.List;

import net.sourceforge.atunes.model.IListOfPlayLists;
import net.sourceforge.atunes.model.IPlayList;

class ListOfPlayListsCreator {

    /**
     * Gets the list of play lists.
     * @param playLists
     * @param filtered
     * @param nonFilteredPlayList 
     * @return the list of play lists
     */
    IListOfPlayLists getListOfPlayLists(IPlayListsContainer playLists) {
    	if (playLists == null || playLists.getPlayListsCount() == 0) {
    		throw new IllegalArgumentException("Playlists empty or null");
    	}
    	
        ListOfPlayLists l = new ListOfPlayLists();

        // Clone play lists to make changes in returned list if current play list is filtered
        List<IPlayList> lists = new ArrayList<IPlayList>();
        for (int i = 0; i < playLists.getPlayListsCount(); i++) {
        	lists.add(playLists.getPlayListAt(i));
        }
        l.setPlayLists(lists);
        l.setSelectedPlayList(playLists.getActivePlayListIndex());

        // If current play list is filtered return non-filtered play list
        if (playLists.isFiltered()) {
            l.getPlayLists().remove(playLists.getActivePlayListIndex());
            l.getPlayLists().add(playLists.getActivePlayListIndex(), playLists.getNonFilteredPlayList());
        }

        return l;
    }

}
