package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.localidadgeneral", "/web.localidadgeneral"})
public final  class localidadgeneral extends GXWebObjectStub
{
   public localidadgeneral( )
   {
   }

   public localidadgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( localidadgeneral.class ));
   }

   public localidadgeneral( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new localidadgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new localidadgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Localidad General";
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

