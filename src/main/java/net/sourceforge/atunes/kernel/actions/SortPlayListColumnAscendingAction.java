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

import net.sourceforge.atunes.model.ColumnSort;
import net.sourceforge.atunes.model.IColumn;
import net.sourceforge.atunes.model.IColumnModel;
import net.sourceforge.atunes.model.IColumnSetPopupAction;
import net.sourceforge.atunes.model.IColumnSetTableModel;
import net.sourceforge.atunes.utils.I18nUtils;

/**
 * This action calls sort play list by selected column forcing ascending order
 * 
 * @author fleax
 * 
 */
public class SortPlayListColumnAscendingAction implements IColumnSetPopupAction {

	@Override
	public void executeAction(IColumn<?> column, IColumnModel columnModel,
			IColumnSetTableModel tableModel) {
		column.setColumnSort(ColumnSort.ASCENDING);
		tableModel.sort(column);
	}

	@Override
	public String getText() {
		return I18nUtils.getString("SORT_ASCENDING");
	}
}
