package fukushima;
public class Lesson07 {
	public static void main(String[] args) {
		Dog taro=new Dog("TARO",20230101);
		Dog jiro=new Dog("TARO",20230101);
		Dog santa=jiro;
		Dog shiro=taro.clone();
		System.out.println(taro==jiro);
		System.out.println(taro.equals(jiro));
		System.out.printf("%d %d\n",taro.hashCode(),jiro.hashCode());
		System.out.println(santa==jiro);
		System.out.println("---");
		System.out.println(taro==shiro);
		System.out.println(taro.equals(shiro));
		System.out.printf("%d %d\n",taro.hashCode(),shiro.hashCode());
		System.out.println("---");
		String str1="Hello";
//		String str1=new String("Hello");
		String str2="Hello";
		System.out.println(str1==str2);
		System.out.println(str1.equals(str2));
		System.out.printf("%d %d\n",str1.hashCode(),str2.hashCode());
	}
}
class Dog implements Cloneable{
	String name;
	int birth;
	public Dog(String name,int birth) {
		this.name=name;
		this.birth=birth;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj==null) return false;
		Dog dog=(Dog)obj;
		if(this.name.equals(dog.name) && this.birth==dog.birth) {
			return true;
		}
		return false;
	}
	@Override
	public int hashCode() {
		int result=name.hashCode();
		result^=birth;
		return result;
	}
	@Override
	public Dog clone() {
		Dog dog;
		try {
			dog = (Dog)super.clone();
			dog.name=this.name;
			dog.birth=this.birth;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
		return dog;
	}

}
