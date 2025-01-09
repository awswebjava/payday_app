package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.localidadview", "/web.localidadview"})
public final  class localidadview extends GXWebObjectStub
{
   public localidadview( )
   {
   }

   public localidadview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( localidadview.class ));
   }

   public localidadview( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new localidadview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new localidadview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Localidad View";
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

