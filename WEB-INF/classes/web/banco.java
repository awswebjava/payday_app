package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.banco", "/web.banco"})
public final  class banco extends GXWebObjectStub
{
   public banco( )
   {
   }

   public banco( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( banco.class ));
   }

   public banco( int remoteHandle ,
                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new banco_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new banco_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Banco";
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
      return "banco_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

