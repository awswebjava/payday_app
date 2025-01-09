package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.religionww", "/web.religionww"})
public final  class religionww extends GXWebObjectStub
{
   public religionww( )
   {
   }

   public religionww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( religionww.class ));
   }

   public religionww( int remoteHandle ,
                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new religionww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new religionww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Religion";
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

