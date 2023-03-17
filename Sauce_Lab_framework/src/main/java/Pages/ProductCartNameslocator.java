package Pages;

public enum ProductCartNameslocator
{
	SauceLabsBackPack ("add-to-cart-sauce-labs-backpack"),
	SauceLabsBikeLight ("add-to-cart-sauce-labs-bike-light"),
	SauceLabsBoltTshirt ("add-to-cart-sauce-labs-bolt-t-shirt"),
	SauceLabsFleeceJacket("add-to-cart-sauce-labs-fleece-jacket"),
	SauceLabsOnesie("add-to-cart-sauce-labs-onesie"),
	TestallTheThingsTShirtRed("add-to-cart-test.allthethings()-t-shirt-(red)"),
	SauceLabsBackPackRemove ("remove-sauce-labs-backpack")	;

	private final String name;       

	private ProductCartNameslocator(String s) {
		name = s;
	}
	public String toString() {
	       return this.name;
	    }
}
