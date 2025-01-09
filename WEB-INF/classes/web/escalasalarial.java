package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.escalasalarial", "/web.escalasalarial"})
public final  class escalasalarial extends GXWebObjectStub
{
   public escalasalarial( )
   {
   }

   public escalasalarial( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( escalasalarial.class ));
   }

   public escalasalarial( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new escalasalarial_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new escalasalarial_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Escala Salarial";
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

