package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.origen", "/web.origen"})
public final  class origen extends GXWebObjectStub
{
   public origen( )
   {
   }

   public origen( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( origen.class ));
   }

   public origen( int remoteHandle ,
                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new origen_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new origen_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Origen";
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

