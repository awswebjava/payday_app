package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.empbasehoranormal", "/web.empbasehoranormal"})
public final  class empbasehoranormal extends GXWebObjectStub
{
   public empbasehoranormal( )
   {
   }

   public empbasehoranormal( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( empbasehoranormal.class ));
   }

   public empbasehoranormal( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new empbasehoranormal_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new empbasehoranormal_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Emp Base Hora Normal";
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

