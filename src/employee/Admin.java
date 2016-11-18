package employee;

public class Admin {
	
	private static String name;
	private static String password;
	
	
	public Admin(){
		setName("admin");
		setPassword("admin");
	}
	
	public Admin(String name, String password){
		setName(name);
		setPassword(password);	
	}
	
	public static String getName(){
		return name;
	}
	
	public static String getPassword(){
		return password;
	}
	
	public static void setName(String n){
		name = n;
	}
	
	public static void setPassword(String p){
		password = p;
	}
	

}
