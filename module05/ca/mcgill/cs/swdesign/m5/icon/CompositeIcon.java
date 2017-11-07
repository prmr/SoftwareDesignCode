package ca.mcgill.cs.swdesign.m5.icon;

import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;

/**
 * To be completed.
 *
 */
public class CompositeIcon implements Icon
{
	private final List<Icon> aIcons = new ArrayList<>();
	
	public void addIcon(Icon pIcon)
	{
		aIcons.add(pIcon);
	}
	
	@Override
	public int getIconHeight()
	{
		int max = 0;
		for( Icon icon : aIcons )
		{
			max = Math.max(max, icon.getIconHeight());
		}
		return max;
	}

	@Override
	public int getIconWidth()
	{
		int max = 0;
		for( Icon icon : aIcons )
		{
			max = Math.max(max, icon.getIconWidth());
		}
		return max;
	}

	@Override
	public void paintIcon(Component pComponent, Graphics pGraphics, int pX, int pY)
	{
		for( Icon icon : aIcons )
		{
			icon.paintIcon(pComponent, pGraphics, pX, pY);
		}
	}
}
