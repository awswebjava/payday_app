package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.localidad", "/web.localidad"})
public final  class localidad extends GXWebObjectStub
{
   public localidad( )
   {
   }

   public localidad( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( localidad.class ));
   }

   public localidad( int remoteHandle ,
                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new localidad_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new localidad_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Localidad";
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
      return "localidad_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

