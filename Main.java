/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package school;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author viki
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

        School s=new School();
    Scanner in =new Scanner(System.in);
    System.out.println("--------------school Database-----------");
try {
			while (true) {

        System.out.println("1.create record\t2.update Record\t3.view data\t4.exit");
   int ch=in.nextInt();
        switch(ch){
            case 1:
                s.create();
                break;
            case  2:
                s.update();
                break;
            case 3:
                s.view();
                break;
            case 4:
                System.exit(0);
                break;
                			default:
					System.out.println("Invalid Option");

    }
        	}
		} catch (Exception e) {
			System.out.println("SELF THROWN EXCEPTION IS--->" + e);
		} finally {
			in.close();
		}}
       
    


}
