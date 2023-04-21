
package com.emergentes.controller;

import com.emergentes.modelo.Estudiante;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "NuevoEstudiante", urlPatterns = {"/NuevoEstudiante"})
public class NuevoEstudiante extends HttpServlet {

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        
        if (ses.getAttribute("listaProducto") == null) {
            ArrayList<Estudiante> listaux = new ArrayList<Estudiante>();
            ses.setAttribute("listaProducto", listaux);
        }
        ArrayList<Estudiante> lista = (ArrayList<Estudiante>)ses.getAttribute("listaProducto");
                
        String op = request.getParameter("op");
        String option = (op != null) ? op:"view";
        
        Estudiante obj1 = new Estudiante();
        int id,pos;
        
        switch(option){ 
            case "nuevo":
                request.setAttribute("miEstudiante", obj1);
                request.getRequestDispatcher("Resgistro.jsp").forward(request, response);
                break;
                
            case "editar":
                id=Integer.parseInt(request.getParameter("id"));
                pos = buscarIndice(request,id);
                obj1 = lista.get(pos);
                request.setAttribute("miEstudiante", obj1);
                request.getRequestDispatcher("Resgistro.jsp").forward(request, response);
                break;
            case "eliminar":
                id=Integer.parseInt(request.getParameter("id"));
                pos = buscarIndice(request,id);
                lista.remove(pos);
                ses.setAttribute("listaProducto", lista);
                response.sendRedirect("index.jsp");
                break;
                
            case "view":
                response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        ArrayList<Estudiante> Product = (ArrayList<Estudiante>)ses.getAttribute("listaProducto");
        
        Estudiante pro = new Estudiante();
        
        pro.setId(Integer.parseInt(request.getParameter("id")));
        pro.setNombre(request.getParameter("nombre"));
        pro.setP1(Integer.parseInt(request.getParameter("p1")));
        pro.setP2(Integer.parseInt(request.getParameter("p2")));
        pro.setEF(Integer.parseInt(request.getParameter("ef")));
        pro.setNota(pro.getP1() + pro.getP2() + pro.getEF());
        
        int idt =pro.getId();
        
        if (idt == 0) { 
            int ultId;
            ultId = ultimoId(request);
            pro.setId(ultId);
            Product.add(pro);
        }
        else{
            //edicion
            Product.set(buscarIndice(request,idt),pro);
        }
        ses.setAttribute("listaper", Product);

        response.sendRedirect("index.jsp");
    }
private int buscarIndice(HttpServletRequest request, int id){
        HttpSession ses = request.getSession();
        ArrayList<Estudiante> lista = (ArrayList<Estudiante>)ses.getAttribute("listaProducto");
        
        int i=0;
        
        if (lista.size() > 0) {
            while(i < lista.size()){
                if (lista.get(i).getId() == id) {
                    break;
                }
                else{
                    i++;
                }
            }
        }
        return i;
    }
    private int ultimoId(HttpServletRequest request){
        HttpSession ses = request.getSession();
        ArrayList<Estudiante> lista = (ArrayList<Estudiante>)ses.getAttribute("listaProducto");
        
        int idaux = 0;
        for (Estudiante item: lista) {
            idaux = item.getId();
        }
        return idaux+1;
    }  
}
