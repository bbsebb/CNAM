package nfa035.td.td4.exo2;

public class Rectangle {
	private Point pointGInf, pointDSup,pointGSup,pointDInf;

	Rectangle() {
		this.setPointGInf(new Point());
		this.setPointDSup(new Point());
		
	}

	Rectangle(Point point1, Point point2) {
		this.setPointGInf(point2);
		this.setPointDSup(point1);
		this.ordonner();
	}

	Rectangle(int xPoint1, int yPoint1, int xPoint2, int yPoint2) {
		this.setPointGInf(new Point(xPoint1,yPoint1));
		this.setPointDSup(new Point(xPoint2,yPoint2));
		this.ordonner();
	}

	void ordonner() {

	}
	
	

	/**
	 * @return le pointGInf
	 */
	public Point getPointGInf() {
		return pointGInf;
	}

	/**
	 * @param pointGInf le pointGInf à éditer
	 */
	public void setPointGInf(Point pointGInf) {
		this.pointGInf = pointGInf;
	}

	/**
	 * @return le pointDSup
	 */
	public Point getPointDSup() {
		return pointDSup;
	}

	/**
	 * @param pointDSup le pointDSup à éditer
	 */
	public void setPointDSup(Point pointDSup) {
		this.pointDSup = pointDSup;
	}

	/**
	 * @return le pointGSup
	 */
	public Point getPointGSup() {
		return pointGSup;
	}

	/**
	 * @param pointGSup le pointGSup à éditer
	 */
	public void setPointGSup(Point pointGSup) {
		this.pointGSup = pointGSup;
	}

	/**
	 * @return le pointDinf
	 */
	public Point getPointDInf() {
		return pointDInf;
	}

	/**
	 * @param pointDinf le pointDinf à éditer
	 */
	public void setPointDInf(Point pointDinf) {
		this.pointDInf = pointDinf;
	}

}
