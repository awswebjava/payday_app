package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.paisextraordinarias", "/web.paisextraordinarias"})
public final  class paisextraordinarias extends GXWebObjectStub
{
   public paisextraordinarias( )
   {
   }

   public paisextraordinarias( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( paisextraordinarias.class ));
   }

   public paisextraordinarias( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new paisextraordinarias_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new paisextraordinarias_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Pais Extraordinarias";
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

