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

package net.sourceforge.atunes.kernel.actions;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import net.sourceforge.atunes.model.IPodcastFeedHandler;

import org.junit.Assert;
import org.junit.Test;

public class AddPodcastFeedActionTest {

	@Test
	public void test() {
		AddPodcastFeedAction sut = new AddPodcastFeedAction();
		IPodcastFeedHandler podcastFeedHandler = mock(IPodcastFeedHandler.class);
		sut.setPodcastFeedHandler(podcastFeedHandler);
		
		sut.executeAction();
		
		verify(podcastFeedHandler).addPodcastFeed();
		Assert.assertTrue(sut.isEnabledForNavigationTreeSelection(false, null)); // Always true
	}
}
