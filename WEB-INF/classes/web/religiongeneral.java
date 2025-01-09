package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.religiongeneral", "/web.religiongeneral"})
public final  class religiongeneral extends GXWebObjectStub
{
   public religiongeneral( )
   {
   }

   public religiongeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( religiongeneral.class ));
   }

   public religiongeneral( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new religiongeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new religiongeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Religion General";
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

