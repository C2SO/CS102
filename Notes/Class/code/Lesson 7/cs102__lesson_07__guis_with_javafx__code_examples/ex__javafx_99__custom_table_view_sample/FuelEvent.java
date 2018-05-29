


// ...
public class FuelEvent {

	private String plate; // ...
	private String date; // ...
	private int	mileage; // ...
	private float fuel; // ...
	private float mpg; // ...

	// Constructor.
	public FuelEvent( String plate, String date, int mileage, float fuel ) {
		this.plate = plate;
		this.date = date;
		this.mileage = mileage;
		this.fuel = fuel;
		this.mpg = 0.0F;
	}
   
	// Accessors.
   public String getPlate() { return plate; }
   public String getDate() { return date.substring( 0, 4 ) + "-" + date.substring( 4, 6 ) + "-" + date.substring( 6, 8 ); }
   public int isMileage() { return mileage; }
   public String getMileage() { return Integer.toString( mileage ) + " mi."; }
   public String getFuel() { return Float.toString( fuel ) + " gal."; }
   public float isFuel() { return fuel; }
   public float isMpg() { return mpg; }
   public String getMpg() { return Float.toString( mpg ) + " mpg"; }
   
	// Modifiers.
   public void setPlate( String plate ) { this.plate = plate; }
   public void setDate( String date ) { this.date = date; }
   public void setMileage( int mileage ) { this.mileage = mileage; }
   public void setFuel( float fuel ) { this.fuel = fuel; }
   public void setMpg( float mpg ) { this.mpg = mpg; }
   
}


