package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.aexcelhistorico", "/web.aexcelhistorico"})
public final  class aexcelhistorico extends GXWebObjectStub
{
   public aexcelhistorico( )
   {
   }

   public aexcelhistorico( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( aexcelhistorico.class ));
   }

   public aexcelhistorico( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new aexcelhistorico_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new aexcelhistorico_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Excel Historico";
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

