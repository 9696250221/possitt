import java.io.*;
import java.util.*;
import java.security.*;
import java.math.*;
class Node{

        Node parent;
       //variable for checking the value of data of parent and child diffirence.
        public  int checkValue;
	Date timeStamp ; 
	String data;
	int nodeNumber;
	String nodeId;
	String referenceNodeId;
	String childReferenceNodeId;
	String genesisReferenceNodeId ; 
	String HashValue ;
	
	//Constructor For Creating a Non Genesis Node

	Node( Node parent ,Date timeStamp ,String data,int nodeNumber,	String nodeId,String referenceNodeId
        ,String childReferenceNodeId,String genesisReferenceNodeId )  throws Exception
	{ 
	      this.parent = parent;
     	      this.timeStamp = new Date() ; 
              int temp = Integer.parseInt(data);
              this.parent.checkValue = parent.checkValue - temp; 
              if(this.parent.checkValue>0)
		{
	         this.data = data;
                  this.checkValue = Integer.parseInt(data);
		}
		else
		{
                    this.checkValue = 0;
 		System.exit(0);
		}
		this.nodeNumber = nodeNumber;
		this.nodeId = nodeId;
		this.referenceNodeId = referenceNodeId;
		this.childReferenceNodeId = childReferenceNodeId;
		this.genesisReferenceNodeId = genesisReferenceNodeId ; 
		this.HashValue  = this.getHashValue(data);
                
             
	    
	}
	
	
	//Constructor For Creating a  Genesis Node
	Node(Date timeStamp ,String data,int nodeNumber,	String nodeId,	String referenceNodeId,
	String childReferenceNodeId,	String genesisReferenceNodeId)  throws Exception
	{ 
	        this.parent = null;
    	        this.timeStamp = timeStamp; 
	        this.data = data;
                this.checkValue = Integer.parseInt(data);
		this.nodeNumber = nodeNumber;
		this.nodeId = nodeId;
		this.referenceNodeId = referenceNodeId;
		this.childReferenceNodeId = childReferenceNodeId;
		this.genesisReferenceNodeId = genesisReferenceNodeId ; 
		this.HashValue  = this.getHashValue(data);
	    
	}
      
      // Method for fingding the Hash value on the basis of data.
        public String getHashValue(String data) throws Exception
       {
        String s=data;
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(s.getBytes() , 0 , s.length());
        return (new BigInteger(1,m.digest()).toString(16));
       }


         
        //Driver Method 
	public static void main(String arr[])  throws Exception
	{
	    Node Gnode = new Node(new Date() , "30" , 1 , "10" , "5" , "5" , "1" );
	    System.out.println( Gnode.checkValue);
            Node Gnodebaccha = new Node(Gnode,new Date() , "17" , 1 , "10" , "5" , "5" , "1");
	    System.out.println( Gnodebaccha.checkValue);
             System.out.println( Gnodebaccha.HashValue);
        //method for encryption and decryption of data.
          String key =   Gnode.encryptKey();
            System.out.println(key);
	}
     

     public String  encryptKey()
     {
            String  encryptedKey = AES.encrypt(data, HashValue);
            return encryptedKey;
          
    }




	
}
