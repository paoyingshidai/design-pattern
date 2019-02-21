package com.michael.decorator.shape;

public class YellowShapeDecorator extends ShapeDecorator {

	public YellowShapeDecorator(Shape decoratedShape) {
		super(decoratedShape);
	}

	@Override
	public void draw() {
		decoratedShape.draw();
		setYellowBorder(decoratedShape);
	}

	private void setYellowBorder(Shape decoratedShape) {
		System.out.println("Border Color: Yellow");
	}
	
}
