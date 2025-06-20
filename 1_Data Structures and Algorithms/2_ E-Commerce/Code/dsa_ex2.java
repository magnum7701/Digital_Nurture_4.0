import java.util.*;

class ProductList{
	String name;
	int id;
	String category;

	ProductList(String name,int id,String category){
		this.name=name;
		this.id=id;
		this.category=category;
	}
}

class Product{
	
	String productName;

	ProductList[] products = {
	 	new ProductList("AirPods Pro", 17, "Electronics"),
	    new ProductList("Bluetooth Speaker", 3, "Audio"),
	    new ProductList("Canon DSLR Camera", 22, "Camera"),
	    new ProductList("Dell XPS 13 Laptop", 7, "Computers"),
	    new ProductList("Electric Kettle", 19, "Home Appliance"),
	    new ProductList("Fitness Tracker", 11, "Wearables"),
	    new ProductList("Google Pixel 8", 25, "Smartphone"),
	    new ProductList("HP LaserJet Printer", 0, "Office"),
	    new ProductList("iPhone 15 Pro", 13, "Smartphone"),
	    new ProductList("JBL Headphones", 1, "Audio"),
	    new ProductList("KitchenAid Mixer", 9, "Home Appliance"),
	    new ProductList("Logitech MX Master Mouse", 21, "Accessories"),
	    new ProductList("MacBook Air M2", 5, "Computers"),
	    new ProductList("Nikon Z6 II", 15, "Camera"),
	    new ProductList("OnePlus 12", 6, "Smartphone"),
	    new ProductList("PlayStation 5", 24, "Gaming"),
	    new ProductList("QuickCharge Power Bank", 10, "Accessories"),
	    new ProductList("Roku Streaming Stick", 14, "Media"),
	    new ProductList("Samsung Galaxy S24", 8, "Smartphone"),
	    new ProductList("Tesla Model Y Diecast", 23, "Collectibles"),
	    new ProductList("USB-C Hub", 18, "Accessories"),
	    new ProductList("Vitamix Blender", 2, "Home Appliance"),
	    new ProductList("WD External Hard Drive", 16, "Storage"),
	    new ProductList("Xbox Series X", 12, "Gaming"),
	    new ProductList("Yamaha Soundbar", 20, "Audio"),
	    new ProductList("Zebra Thermal Printer", 4, "Office")
};

	Product(){
		productName="";
	}	

	Product(String productName){
		this.productName=productName;
	}

	void linsearch(int input_id){
		int i,flag=0;
		for (i=0;i<products.length;i++){
			System.out.println("Checking index: " + i + ", ID: " + products[i].id);
			if((products[i].id)==input_id){
				flag++;
				System.out.println("Found "+productName+" after "+i+" iteration(s).");
				break;
			}
		}
		if(flag==0) System.out.println("Product not found.");
	}

	void binsearch(int input_id){
		ProductList[] sorted = new ProductList[products.length];
		sorted = Arrays.copyOf(products, products.length); 
		for(int i=0;i<sorted.length;i++){
			for(int j=0;j<sorted.length-i-1;j++){
				if(sorted[j].id>sorted[j+1].id){
					ProductList temp = sorted[j];
					sorted[j]=sorted[j+1];
					sorted[j+1]=temp;
				}
			}
		}
		 // for(int i=0;i<sorted.length;i++)
		// 	System.out.println(sorted[i].name+" "+sorted[i].id+" "+sorted[i].category);
		int low = 0,flag=0,iteration=0,mid=-1;
		int high = sorted.length-1;
		while(low<=high){
			iteration++;
			mid = low + (high-low)/2;
			System.out.println("Checking index: " + mid + ", ID: " + sorted[mid].id);
			if(sorted[mid].id==input_id){
				flag++;
				break;
			}
			else if(input_id<sorted[mid].id){high=mid-1;}
			else if(input_id>sorted[mid].id){low=mid+1;}
		}
		if(flag>0)System.out.println("Product found : "+sorted[mid].name+" ! Number of iterations : "+iteration);
		else System.out.println("Product not found.");


	 }

}

public class dsa_ex2{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Product p = new Product();
		int choice;
		// String productName;
		System.out.println("Enter choice (1) for linear search , (2) for binary search : ");
		choice = sc.nextInt();
		sc.nextLine();
		switch(choice){
			case 1 :
				System.out.println("Enter id of product you want to search : ");
				int productid = sc.nextInt();
				p.linsearch(productid);
			break;
			case 2:
				System.out.println("Enter product  id of product you want to search : ");
				int input_id = sc.nextInt();
				p.binsearch(input_id);	
			break;
			default:
				System.out.println("Invalid choice");	
		}
	}
}
