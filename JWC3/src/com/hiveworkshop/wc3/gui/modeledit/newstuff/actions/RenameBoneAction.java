package com.hiveworkshop.wc3.gui.modeledit.newstuff.actions;

import com.hiveworkshop.wc3.gui.modeledit.UndoAction;
import com.hiveworkshop.wc3.mdl.IdObject;

public final class RenameBoneAction implements UndoAction {
	private final String oldName;
	private final String newName;
	private final IdObject nodeToRename;

	public RenameBoneAction(final String oldName, final String newName, final IdObject nodeToRename) {
		this.oldName = oldName;
		this.newName = newName;
		this.nodeToRename = nodeToRename;
	}

	@Override
	public void undo() {
		nodeToRename.setName(oldName);
	}

	@Override
	public void redo() {
		nodeToRename.setName(newName);
	}

	@Override
	public String actionName() {
		return "rename " + oldName + " to " + newName;
	}
}
