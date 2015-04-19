package whsdu.se.Common;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.DefaultDesktopManager;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

/**
 * 这个类可以不必掌握，有兴趣的同学看看！
 * 本类直接使用了 java 示例的代码，与 MDIDesktopPane 类配合，实现为 MDI 添加滚动条
 * 以下是原文档的说明：
 * Private class used to replace the standard DesktopManager for JDesktopPane.
 * Used to provide scrollbar functionality.
 */
public class MDIDesktopManager extends DefaultDesktopManager {
	private MDIDesktopPane desktop;

	public MDIDesktopManager(MDIDesktopPane desktop) {
		this.desktop = desktop;
	}

	public void endResizingFrame(JComponent f) {
		super.endResizingFrame(f);
		resizeDesktop();
	}

	public void endDraggingFrame(JComponent f) {
		super.endDraggingFrame(f);
		resizeDesktop();
	}

	public void setNormalSize() {
		JScrollPane scrollPane = getScrollPane();
		int x = 0;
		int y = 0;
		Insets scrollInsets = getScrollPaneInsets();

		if (scrollPane != null) {
			Dimension d = scrollPane.getVisibleRect().getSize();
			if (scrollPane.getBorder() != null) {
				d.setSize(d.getWidth() - scrollInsets.left - scrollInsets.right, d.getHeight()
						- scrollInsets.top - scrollInsets.bottom);
			}

			d.setSize(d.getWidth() - 20, d.getHeight() - 20);
			desktop.setAllSize(x, y);
			scrollPane.invalidate();
			scrollPane.validate();
		}
	}

	private Insets getScrollPaneInsets() {
		JScrollPane scrollPane = getScrollPane();
		if (scrollPane == null)
			return new Insets(0, 0, 0, 0);
		else
			return getScrollPane().getBorder().getBorderInsets(scrollPane);
	}

	private JScrollPane getScrollPane() {
		if (desktop.getParent() instanceof JViewport) {
			JViewport viewPort = (JViewport) desktop.getParent();
			if (viewPort.getParent() instanceof JScrollPane)
				return (JScrollPane) viewPort.getParent();
		}
		return null;
	}

	protected void resizeDesktop() {
		int x = 0;
		int y = 0;
		JScrollPane scrollPane = getScrollPane();
		Insets scrollInsets = getScrollPaneInsets();

		if (scrollPane != null) {
			JInternalFrame allFrames[] = desktop.getAllFrames();
			for (int i = 0; i < allFrames.length; i++) {
				if (allFrames[i].getX() + allFrames[i].getWidth() > x) {
					x = allFrames[i].getX() + allFrames[i].getWidth();
				}
				if (allFrames[i].getY() + allFrames[i].getHeight() > y) {
					y = allFrames[i].getY() + allFrames[i].getHeight();
				}
			}
			Dimension d = scrollPane.getVisibleRect().getSize();
			if (scrollPane.getBorder() != null) {
				d.setSize(d.getWidth() - scrollInsets.left - scrollInsets.right, d.getHeight()
						- scrollInsets.top - scrollInsets.bottom);
			}

			if (x <= d.getWidth())
				x = ((int) d.getWidth()) - 20;
			if (y <= d.getHeight())
				y = ((int) d.getHeight()) - 20;
			desktop.setAllSize(x, y);
			scrollPane.invalidate();
			scrollPane.validate();
		}
	}
}
