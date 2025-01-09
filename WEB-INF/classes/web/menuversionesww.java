package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.menuversionesww", "/web.menuversionesww"})
public final  class menuversionesww extends GXWebObjectStub
{
   public menuversionesww( )
   {
   }

   public menuversionesww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( menuversionesww.class ));
   }

   public menuversionesww( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new menuversionesww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new menuversionesww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Menu Versiones";
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

