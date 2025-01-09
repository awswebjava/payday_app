package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.lsd_reg1lsd_reg5wc", "/web.lsd_reg1lsd_reg5wc"})
public final  class lsd_reg1lsd_reg5wc extends GXWebObjectStub
{
   public lsd_reg1lsd_reg5wc( )
   {
   }

   public lsd_reg1lsd_reg5wc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( lsd_reg1lsd_reg5wc.class ));
   }

   public lsd_reg1lsd_reg5wc( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new lsd_reg1lsd_reg5wc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new lsd_reg1lsd_reg5wc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "LSD_reg1 LSD_reg5 WC";
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

