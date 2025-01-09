package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.parametrosbackend", "/web.parametrosbackend"})
public final  class parametrosbackend extends GXWebObjectStub
{
   public parametrosbackend( )
   {
   }

   public parametrosbackend( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( parametrosbackend.class ));
   }

   public parametrosbackend( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new parametrosbackend_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new parametrosbackend_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Parámetros";
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

