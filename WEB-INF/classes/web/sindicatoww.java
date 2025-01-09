package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.sindicatoww", "/web.sindicatoww"})
public final  class sindicatoww extends GXWebObjectStub
{
   public sindicatoww( )
   {
   }

   public sindicatoww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( sindicatoww.class ));
   }

   public sindicatoww( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new sindicatoww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new sindicatoww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Sindicato";
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

