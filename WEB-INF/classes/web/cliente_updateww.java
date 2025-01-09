package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.cliente_updateww", "/web.cliente_updateww"})
public final  class cliente_updateww extends GXWebObjectStub
{
   public cliente_updateww( )
   {
   }

   public cliente_updateww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( cliente_updateww.class ));
   }

   public cliente_updateww( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new cliente_updateww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new cliente_updateww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Actualizaciones";
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

