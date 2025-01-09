package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.lsd_reg2lsd_reg3wc", "/web.lsd_reg2lsd_reg3wc"})
public final  class lsd_reg2lsd_reg3wc extends GXWebObjectStub
{
   public lsd_reg2lsd_reg3wc( )
   {
   }

   public lsd_reg2lsd_reg3wc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( lsd_reg2lsd_reg3wc.class ));
   }

   public lsd_reg2lsd_reg3wc( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new lsd_reg2lsd_reg3wc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new lsd_reg2lsd_reg3wc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "LSD_reg2 LSD_reg3 WC";
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

