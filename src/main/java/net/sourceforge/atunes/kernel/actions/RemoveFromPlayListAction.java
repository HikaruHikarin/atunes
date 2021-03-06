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

import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.KeyStroke;

import net.sourceforge.atunes.model.IAudioObject;
import net.sourceforge.atunes.model.IPlayListHandler;
import net.sourceforge.atunes.utils.I18nUtils;

/**
 * This action removes from play list selected rows
 * 
 * @author fleax
 * 
 */
public class RemoveFromPlayListAction extends CustomAbstractAction {

	private static final long serialVersionUID = 7249538257655420803L;

	private IPlayListHandler playListHandler;

	/**
	 * @param playListHandler
	 */
	public void setPlayListHandler(final IPlayListHandler playListHandler) {
		this.playListHandler = playListHandler;
	}

	/**
	 * Default constructor
	 */
	public RemoveFromPlayListAction() {
		super(I18nUtils.getString("REMOVE"));
		putValue(SHORT_DESCRIPTION, I18nUtils.getString("REMOVE_TOOLTIP"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
		setEnabled(false);
	}

	@Override
	protected void executeAction() {
		playListHandler.deleteSelection();
	}

	@Override
	public boolean isEnabledForPlayListSelection(final List<IAudioObject> selection) {
		return selection != null && !selection.isEmpty();
	}

}
