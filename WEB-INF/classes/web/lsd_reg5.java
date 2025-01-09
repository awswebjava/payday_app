package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.lsd_reg5", "/web.lsd_reg5"})
public final  class lsd_reg5 extends GXWebObjectStub
{
   public lsd_reg5( )
   {
   }

   public lsd_reg5( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( lsd_reg5.class ));
   }

   public lsd_reg5( int remoteHandle ,
                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new lsd_reg5_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new lsd_reg5_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "LSD_reg5";
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

