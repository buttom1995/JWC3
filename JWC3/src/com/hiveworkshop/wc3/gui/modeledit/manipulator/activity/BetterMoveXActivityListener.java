package com.hiveworkshop.wc3.gui.modeledit.manipulator.activity;

import java.awt.geom.Point2D.Double;

import com.hiveworkshop.wc3.gui.modeledit.manipulator.ModelEditor;
import com.hiveworkshop.wc3.gui.modeledit.useractions.UndoActionListener;

public final class BetterMoveXActivityListener extends AbstractBetterMoveActivityListener {

	public BetterMoveXActivityListener(final ModelEditor modelEditor, final UndoActionListener undoManager) {
		super(modelEditor, undoManager);
	}

	@Override
	protected void buildMoveVector(final Double mouseStart, final Double mouseEnd, final byte dim1, final byte dim2) {
		moveVector.setCoord(dim1, mouseEnd.x - mouseStart.x);
	}

}
