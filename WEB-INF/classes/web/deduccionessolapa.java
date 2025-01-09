package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.deduccionessolapa", "/web.deduccionessolapa"})
public final  class deduccionessolapa extends GXWebObjectStub
{
   public deduccionessolapa( )
   {
   }

   public deduccionessolapa( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( deduccionessolapa.class ));
   }

   public deduccionessolapa( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new deduccionessolapa_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new deduccionessolapa_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "deducciones Solapa";
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

