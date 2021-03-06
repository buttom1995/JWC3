package com.hiveworkshop.wc3.gui.modeledit.newstuff.actions.animation;

import java.util.List;

import com.hiveworkshop.wc3.gui.modeledit.UndoAction;
import com.hiveworkshop.wc3.mdl.AnimFlag;

public class SlideKeyframeAction implements UndoAction {
	private final int startTrackTime;
	private final int endTrackTime;
	private final List<AnimFlag> timelines;
	private final Runnable keyframeChangeCallback;

	public SlideKeyframeAction(final int startTrackTime, final int endTrackTime, final List<AnimFlag> timelines,
			final Runnable keyframeChangeCallback) {
		this.startTrackTime = startTrackTime;
		this.endTrackTime = endTrackTime;
		this.timelines = timelines;
		this.keyframeChangeCallback = keyframeChangeCallback;
	}

	@Override
	public void undo() {
		for (final AnimFlag timeline : timelines) {
			timeline.slideKeyframe(endTrackTime, startTrackTime);
		}
		keyframeChangeCallback.run();
	}

	@Override
	public void redo() {
		for (final AnimFlag timeline : timelines) {
			timeline.slideKeyframe(startTrackTime, endTrackTime);
		}
		keyframeChangeCallback.run();
	}

	@Override
	public String actionName() {
		return "slide keyframe";
	}

}
