
package controlador.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class Mensaje {    
    HttpSession sesion;

    public Mensaje(HttpServletRequest request) {        
        sesion = request.getSession();        
    }

    public String getMsg() {
        String msg = (String)sesion.getAttribute("msg");
        this.setMsg("");
        return msg;
    }

    public void setMsg(String msg) {
        sesion.setAttribute("msg", msg);
    }
    
}
