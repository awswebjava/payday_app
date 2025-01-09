package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.lsd_reg2lsd_reg4wc", "/web.lsd_reg2lsd_reg4wc"})
public final  class lsd_reg2lsd_reg4wc extends GXWebObjectStub
{
   public lsd_reg2lsd_reg4wc( )
   {
   }

   public lsd_reg2lsd_reg4wc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( lsd_reg2lsd_reg4wc.class ));
   }

   public lsd_reg2lsd_reg4wc( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new lsd_reg2lsd_reg4wc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new lsd_reg2lsd_reg4wc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "LSD_reg2 LSD_reg4 WC";
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

