package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.localidadww", "/web.localidadww"})
public final  class localidadww extends GXWebObjectStub
{
   public localidadww( )
   {
   }

   public localidadww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( localidadww.class ));
   }

   public localidadww( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new localidadww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new localidadww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Localidad";
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

