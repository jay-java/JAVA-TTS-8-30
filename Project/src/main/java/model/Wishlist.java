package model;

public class Wishlist {
	private int wid, pid, cid;

	public int getWid() {
		return wid;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "Wishlist [wid=" + wid + ", pid=" + pid + ", cid=" + cid + "]";
	}

}
