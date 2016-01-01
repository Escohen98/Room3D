import java.util.ArrayList;

public class GetSpace extends Space3D {
	public ArrayList<int[]> getRightWall() {
		ArrayList<int[]> rightWall = new ArrayList<int[]>();
		rightWall.add(yWallRight);
		rightWall.add(xWallRight);
		return rightWall;
	}

	public ArrayList<int[]> getLeftWall() {
		ArrayList<int[]> leftWall = new ArrayList<int[]>();
		leftWall.add(yWallLeft);
		leftWall.add(xWallLeft);
		return leftWall;
	}

	public ArrayList<int[]> getFloor(int x) {
		ArrayList<int[]> Floor = new ArrayList<int[]>();
		Floor.add(yFloor);
		Floor.add(xFloor);
		return Floor;
	}

	public ArrayList<int[]> getBackWall() {
		ArrayList<int[]> backWall = new ArrayList<int[]>();
		backWall.add(yWallBack);
		backWall.add(xWallBack);
		return backWall;
	}

	public ArrayList<int[]> getCeil() {
		ArrayList<int[]> Ceil = new ArrayList<int[]>();
		Ceil.add(yCeil);
		Ceil.add(xCeil);
		return Ceil;
	}
}
