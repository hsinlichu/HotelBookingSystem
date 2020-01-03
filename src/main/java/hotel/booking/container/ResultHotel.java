package hotel.booking.container;


public class ResultHotel {
	public int id;
	public int star;
	public String locality;
	public String street;
	public int singleRoomNum;
	public int singleRoomPrice;
	public int doubleRoomNum;
	public int doubleRoomPrice;
	public int quadRoomNum;
	public int quadRoomPrice;
	public int avgprice;
	
	public ResultHotel(){
		//Default constructor
		this.id = 0;
		this.star = 0;
		this.locality = "";
		this.street = "";
		this.singleRoomNum = 0;
		this.singleRoomPrice = 0;
		this.doubleRoomNum = 0;
		this.doubleRoomPrice = 0;
		this.quadRoomNum = 0;
		this.quadRoomPrice = 0;
		this.avgprice = 0;
	}
}
