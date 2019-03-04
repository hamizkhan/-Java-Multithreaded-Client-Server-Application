import java.io.Serializable;

//
public class MyString implements Serializable
{

	private String string;
	private int stringLength;
	
	public MyString()
	{
		string="";
	}
	
	public MyString(String string)
	{
		this.string=string;
		
	}
	
	public void setString(String string)
	{
		this.string=string;
	}
	
	public String getString()
	{
		return string;
	}
	
	public void setStringLength(int stringLength)
	{
		this.stringLength=stringLength;
	}
	
	public int getStringLength()
	{
		return stringLength;
	}
	
	public String reverseString()
	{
		String s="";
		
		for(int i=string.length()-1;i>=0;i--)
			s+=String.format("%s", string.charAt(i));
		
		return s;
		
	}
	
	public void determineLength()
	{
		stringLength=string.length();
		
	}
	
	public String getSubString()
	{
		return string.substring(0, string.length()-2);
		
	}
	
	public String toString()
	{
		String s="";
		
		s+="Original String: "+getString()+"\n";
		s+="Reverse String: "+reverseString()+"\n";
		s+="String Length: "+stringLength+"\n";
		s+="Substring: "+getSubString()+"\n";
		
		return s;
	}
	
}
