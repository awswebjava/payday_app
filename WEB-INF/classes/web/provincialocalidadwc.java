package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.provincialocalidadwc", "/web.provincialocalidadwc"})
public final  class provincialocalidadwc extends GXWebObjectStub
{
   public provincialocalidadwc( )
   {
   }

   public provincialocalidadwc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( provincialocalidadwc.class ));
   }

   public provincialocalidadwc( int remoteHandle ,
                                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new provincialocalidadwc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new provincialocalidadwc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Provincia Localidad WC";
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

