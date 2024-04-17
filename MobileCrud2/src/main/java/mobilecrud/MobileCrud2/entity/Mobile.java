package mobilecrud.MobileCrud2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Mobile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String brand;
	private String model;
	private String processor;
	private int batteryMah;
	private int cameraMegaPixel;
	private double price;
	public Mobile(int id, String brand, String model, String processor, int batteryMah, int cameraMegaPixel,
			double price) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.processor = processor;
		this.batteryMah = batteryMah;
		this.cameraMegaPixel = cameraMegaPixel;
		this.price = price;
	}
	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public String getBrand() {
		return brand;
	}
	public String getModel() {
		return model;
	}
	public String getProcessor() {
		return processor;
	}
	public int getBatteryMah() {
		return batteryMah;
	}
	public int getCameraMegaPixel() {
		return cameraMegaPixel;
	}
	public double getPrice() {
		return price;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public void setBatteryMah(int batteryMah) {
		this.batteryMah = batteryMah;
	}
	public void setCameraMegaPixel(int cameraMegaPixel) {
		this.cameraMegaPixel = cameraMegaPixel;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
