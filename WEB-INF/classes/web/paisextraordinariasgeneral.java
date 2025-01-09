package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.paisextraordinariasgeneral", "/web.paisextraordinariasgeneral"})
public final  class paisextraordinariasgeneral extends GXWebObjectStub
{
   public paisextraordinariasgeneral( )
   {
   }

   public paisextraordinariasgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( paisextraordinariasgeneral.class ));
   }

   public paisextraordinariasgeneral( int remoteHandle ,
                                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new paisextraordinariasgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new paisextraordinariasgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Pais Extraordinarias General";
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

