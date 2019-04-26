//Method reference using non-static method
package com.methodreference;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class Shipment {
	 
	public double calculateWeight() {
	    double weight = 0;
	    // Calculate weight
	    return weight;
	  }

	  public List<Double> calculateOnShipments( List<Shipment> l, Function<Shipment, Double> f) {
		    List<Double> results = new ArrayList<>();
		    for(Shipment s : l) {
		      results.add(f.apply(s));
		    }
		    return results;
		}
}

public class NonStaticMethodRef {
	public static void main(String [] args) {
		List<Shipment> l = new ArrayList<Shipment>();
	Shipment shipment=new Shipment();

	// Using an anonymous class
	System.out.println(shipment.calculateOnShipments(l, new Function<Shipment, Double>() {
	  public Double apply(Shipment s) { // The object
	    return s.calculateWeight(); // The method
	  }
	}));

	// Using a lambda expression
	System.out.println(shipment.calculateOnShipments(l, s -> s.calculateWeight()));

	// Using a method reference
	//WHY DO WE USE OBJECTTYPE INSETEAD OF CLASS NAME? Maybe because of the Function is taking Shipment parameter
	System.out.println(shipment.calculateOnShipments(l, Shipment::calculateWeight));
}
}

