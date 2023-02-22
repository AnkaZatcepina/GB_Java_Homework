package lesson6;

import java.util.Objects;

public class Laptop {
    private int id;
    private String firm;
    private String model; 
    private double screenDiagonalInch;
    private String color;
    private double weigthKG;
    private String cpuName;
    private double cpuFrequency;
    private int coreAmount;
    private int ramSizeGb;
    private int ssdSizeGb;
    private double priceRub;
    private Boolean inStock;

    public Laptop(int id,
                  String firm,
                  String model,
                  double screenDiagonalInch,
                  String color,
                  double weigthKG,
                  String cpuName,
                  double cpuFrequency,
                  int coreAmount,
                  int ramSizeGb,
                  int ssdSizeGb,
                  double priceRub
                  )
    {
        this.id = id;
        this.firm = firm;
        this.model = model;
        this.screenDiagonalInch = screenDiagonalInch;
        this.color = color;
        this.weigthKG = weigthKG;
        this.cpuName = cpuName;
        this.cpuFrequency = cpuFrequency;
        this.coreAmount = coreAmount;
        this.ramSizeGb = ramSizeGb;
        this.ssdSizeGb = ssdSizeGb;
        this.priceRub = priceRub;
        this.inStock = true;
    }
    public Laptop(int id,
                  String firm,
                  String model
                  )
    {
        this.id = id;
        this.firm = firm;
        this.model = model;
        this.inStock = true;
    }

    public void setPrice(double price)
    {
        this.priceRub = price;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public void sellLaptop()
    {
        this.inStock = false;
    }


    public int getId()
    {
        return this.id;
    }
    
    public String getColor()
    {
        return this.color;
    }

    public double getPrice()
    {
        return this.priceRub;
    }    
    
    public boolean getInStock()
    {
        return this.inStock;
    }


    public String getInfo()
    {   
        String info = "";
        info = "\n\n Laptop " + this.firm + " " + this.model;
        if (this.screenDiagonalInch != 0.0 ) {
            info += "\n Diagonal = " + this.screenDiagonalInch + '"';
        };    
        if (Objects.nonNull(this.color)) {
            info += "\n Color " + this.color;
        }; 
        if (this.weigthKG != 0.0) {
            info += "\n Weigth = " + this.weigthKG + " kg";
        }; 
        if (Objects.nonNull(this.cpuName)) {
            info += "\n CPU " + this.cpuName;
        }; 
        if (this.cpuFrequency != 0.0) {
            info += "\n CPU Frequency = " + this.cpuFrequency + " ghz";
        }; 
        if (this.coreAmount != 0) {
            info += "\n " + this.coreAmount + " cores";
        };   
        if (this.ramSizeGb != 0) {
            info += "\n RAM " + this.ramSizeGb + " gb";
        }; 
        if (this.ssdSizeGb != 0) {
            info += "\n SSD " + this.ssdSizeGb + " gb";
        }; 
        if (this.priceRub != 0.00) {
            info += "\n Price " + this.priceRub + " RUB";
        }; 
        return info;
    }
}
