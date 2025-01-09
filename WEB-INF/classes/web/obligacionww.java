package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.obligacionww", "/web.obligacionww"})
public final  class obligacionww extends GXWebObjectStub
{
   public obligacionww( )
   {
   }

   public obligacionww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( obligacionww.class ));
   }

   public obligacionww( int remoteHandle ,
                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new obligacionww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new obligacionww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Obligacion";
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

