package edu.depaul.se359.model;

public class CoordinatePoint {

	private int xPoint;
	private int yPoint;

    public CoordinatePoint(int x, int y) {

		setxPosition(x);
		setyPosition(y);
	}

    @Override
    public String toString() {
        return "CoordinatePoint{" +
                "xPoint=" + xPoint +
                ", yPoint=" + yPoint +
                '}';
    }

 public void setxPosition(int xPosition) {

 		// we want to deal with just one quadrant in the plane 
 		// only the positive side
        if(xPosition < 0){

            // exection
        }

     this.xPoint = xPosition;
    }


public void setyPosition(int yPosition) {

		// we want to deal with just one quadrant in the plane 
		// only the postive side
        if(yPosition < 0){

            // exection
        }

    this.yPoint = yPosition;
    }



	public int getXpoint(){

		return this.xPoint;

	}


	public int getYpoint(){


		return this.yPoint;
	}


    @Override
    public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		// cast the object
		final CoordinatePoint obj2 = (CoordinatePoint) obj;
		if(this.xPoint != obj2.xPoint){
			return false;
		}

		if(this.yPoint != obj2.xPoint){

			return false;
		}

		// all conditions satisfy
		return true;

	}



}