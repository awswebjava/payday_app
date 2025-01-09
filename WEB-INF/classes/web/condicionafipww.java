package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.condicionafipww", "/web.condicionafipww"})
public final  class condicionafipww extends GXWebObjectStub
{
   public condicionafipww( )
   {
   }

   public condicionafipww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( condicionafipww.class ));
   }

   public condicionafipww( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new condicionafipww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new condicionafipww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Condicion AFIP";
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

