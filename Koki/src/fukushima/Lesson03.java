package fukushima;
import java.util.ArrayList;
import java.util.List;
public class Lesson03 {
	public static void main(String[] args) {
		List<IPrice> backet=new ArrayList<>();
		backet.add(new Hamburger());
		backet.add(new Fishburger());
		backet.add(new Fishburger());
		backet.add(new Coffee("L"));
		int total=0;
		for(IPrice item : backet){
			total+=item.getPrice();
		}
		System.out.println("total="+total);
	}
}
interface IPrice{
	int getPrice();
}
class Hamburger implements IPrice{
	int price=300;
	@Override
	public int getPrice() {
		return price;
	}
}
class Fishburger extends Hamburger{
	public Fishburger(){
		price=350;
	}
}
class Coffee implements IPrice{
	String size;
	public Coffee(String size) {
		this.size=size;
	}
	@Override
	public int getPrice() {
		if(size=="L") {
			return 150;
		}
		return 100;
	}
}
