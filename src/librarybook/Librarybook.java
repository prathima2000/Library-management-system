/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package librarybook;


import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.lang.Exception;

/**
 *
 * @author USER
 */

    
class book implements library
{
      Scanner in=new Scanner(System.in);
        int BookId[]=new int[2];
        String BookName[]=new String[2];
        String Author[]=new String[2];
       String drawdate[]=new String[2];
     String returndate[]=new String[2];
      int status[]=new int[2];
    public book()
        {            
        for(int i=0;i<BookId.length;i++)
        {
            System.out.println("Enter the following details for book "+(i+1));
            System.out.println("Enter the bookid");
            BookId[i]=in.nextInt();
            System.out.println("Enter the BookName");
            BookName[i]=in.next();
            System.out.println("Enter the Author");
            Author[i]=in.next();
            
            
        }}
      
public void drawbook()
{  
    String title;
    System.out.println("Enter the title to search");
     title=in.next();
     int flag=0;
  for(int i=0;i<BookId.length;i++)
      {
    if(BookName[i].equals (title)==true & status[i]==0)
    {
        status[i]=1;
        System.out.println("book is found");
          SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
          Date currdate = new Date();
         drawdate[i]=dateFormat.format(currdate); 
        
         Calendar c = Calendar.getInstance();
        c.setTime(currdate);
        c.add(Calendar.MONTH, 1);
        Date lastdate= c.getTime();
        returndate[i]=dateFormat.format(lastdate);
           flag=1;
    }}
  
if(flag==0)
    System.out.println("book is not found");
}


public void checkstatus()
{
    System.out.println("Enter the title to check status");
     String title1=in.next();
     int flag=0;   //book not in library list
  for(int i=0;i<BookId.length;i++)
  {
    if (BookName[i].equals (title1)==true)
    {
        flag=1; //book present in library list
        if(status[i]==1)
        {
         System.out.println("currently not available");
       System.out.println( "The book draw date"+drawdate[i]);
        System.out.println( "The book should return on or before:"+returndate[i]);
    flag=2;    //book not currently present
        }}}
    if(flag==0)   
               System.out.println("This book is not found in the library");
    
     if(flag==1)
               System.out.println("currently available for drawbook");    
  }


public void reservebook()
{
     System.out.println("Enter the title to reserve book");
    String title2=in.next();
    int flag=0;
  for(int i=0;i<BookId.length;i++)
  {
    if(BookName[i].equals (title2)==true &status[i]==0)
    
        {
            System.out.println("currently available");
        status[i]=1;
        System.out.println("book is reserved");
        flag=1;
        }}
            if(flag==0)
        {
            System.out.println("currently not available");
           }

  }

public void returnbook()
{
   System.out.println("Enter the title of book to be return");
    String title3=in.next();
  for(int i=0;i<BookId.length;i++)
  {
    if(BookName[i].equals (title3)==true & status[i]==1)
    {  
        fine(i); 
    
        status[i]=0;
         System.out.println("the book is returned"); 
        drawdate[i]=returndate[i]=null;
    }
	}
  }   

public void fine(int j)
{

     SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
     Date one;
     Date two; 
     Date currdate = new Date();
         String d=dateFormat.format(currdate); 
         try
         {
       one =dateFormat.parse(d);
       two=dateFormat.parse(returndate[j]);
     
         if(one.getTime()>two.getTime())
         {
        long difference =  (one.getTime()-two.getTime())/86400000;
System.out.println("fine :" +((Math.abs(difference))*5));
         }
         else
             System.out.println("fine :  nil");
             
         }
         catch(Exception e)
                 {}
        
    }
}

public class Librarybook {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   
        book b=new book();
      
  int j,i=1; 
Scanner in=new Scanner(System.in);
while( i==1)
{
System.out.println("1.drawbook\n2.checkstatus\n3.returnbook\n4.reservebook");
System.out.println("enter option");
  int op=in.nextInt();
 
switch(op)
{
    case 1:
  b.drawbook();
  break;
    case 2:
  b.checkstatus();
  break;
    case 3:
       b.returnbook();
       break;
    case 4:
        b.reservebook();
       break;
    default:
        System.out.println("invalid option ");
}
        System.out.println("do u want to continue  1.y/2.n ");
      j=in.nextInt();
        if(j==2)
            i=0;
                    }            
    
// TODO code application logic here
    }
        
}