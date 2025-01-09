package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.sindicato", "/web.sindicato"})
public final  class sindicato extends GXWebObjectStub
{
   public sindicato( )
   {
   }

   public sindicato( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( sindicato.class ));
   }

   public sindicato( int remoteHandle ,
                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new sindicato_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new sindicato_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Sindicato";
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
      return "sindicato_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

