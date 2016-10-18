import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 钱斌 on 2016/8/24.
 */
public class PrimitiveServlet implements Servlet {
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init");
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service");
        PrintWriter pw = servletResponse.getWriter();
        pw.println("Hello Bill");
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {
        System.out.println("destroy");
    }

}
