package ca.mcgill.cs.swdesign.m5.icon;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

/**
 * To be completed.
 */
public class ShiftedIcon implements Icon
{
	private final Icon aShiftedIcon;
	private final int aX;
	private final int aY;
	
	public ShiftedIcon(Icon pIcon, int pX, int pY)
	{
		aShiftedIcon = pIcon;
		aX = pX;
		aY = pY;
	}
	

	@Override
	public int getIconHeight()
	{
		return aShiftedIcon.getIconHeight() + aY;
	}

	@Override
	public int getIconWidth()
	{
		// TODO Auto-generated method stub
		return aShiftedIcon.getIconWidth() + aX;
	}

	@Override
	public void paintIcon(Component pComponent, Graphics pGraphics, int pX, int pY)
	{
		aShiftedIcon.paintIcon(pComponent, pGraphics, pX + aX, pY + aY);
	}
}
