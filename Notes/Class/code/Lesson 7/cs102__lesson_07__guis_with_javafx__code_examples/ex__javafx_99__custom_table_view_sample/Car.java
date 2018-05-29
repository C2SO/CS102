


// ...
public class Car {

	private String plate; // ...
   private int year; // ...
	private String brand; // ...
	private String model; // ...
	private int mileage; // ...
   private float mpg; // ...
	
   // Constructor.
	public Car( String plate, int year, String brand, String model, int mileage ) {
		this.plate = plate;
		this.year = year;
		this.brand = brand;
		this.model = model;
		this.mileage = mileage;
      mpg = 0.0F;
	}
   
	// Accessors.
   public String isPlate() { return plate; }
   public int getYear() { return year; }
   public String getBrand() { return brand; }
   public String getModel() { return model; }
   public int isMileage() { return mileage; }
   public String getMileage() { return Integer.toString( mileage ) + " mi."; }
   public float isMpg() { return mpg; }
   public String getMpg() { return Float.toString( mpg ) + " mpg"; }
   

	// Modifiers.
   public void setPlate( String plate ) { this.plate = plate; }
   public void setYear( int year ) { this.year = year; }
   public void setBrand( String brand ) { this.brand = brand; }
   public void setModel( String model ) { this.model = model; }
   public void setMileage( int mileage ) { this.mileage = mileage; }
   public void setMpg( float mpg ) { this.mpg = mpg; }

}


