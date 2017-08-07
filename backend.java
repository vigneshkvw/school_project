/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package school;

/**
 *
 * @author viki
 */
public class backend {
    private static String DoB;
    private static String address;
    private static String phone;
  private static String Id;
    static String getDoB() {
        return DoB;
    }

    static String getaddress() {
 return address;
    }

    static String getphone() {
        return  phone;
    }

    static void setDoB(String DoB) {
       backend.DoB=DoB;
    }

    static void setId(String id) {
        backend.Id=id;
    }
   static String getId() {
        return  Id;
    }

    static void setaddress(String address) {
backend.address=address;
    }

    static void setphone(String phone) {
backend.phone=phone;
    }

public static  void setName(String name) {
        backend.name=name;
    }

    public static  String getName(){
        return name;
    }
    public static String name;


}
