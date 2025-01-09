package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.empresa", "/web.empresa"})
public final  class empresa extends GXWebObjectStub
{
   public empresa( )
   {
   }

   public empresa( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( empresa.class ));
   }

   public empresa( int remoteHandle ,
                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new empresa_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new empresa_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Empresa";
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
      return "empresa_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

