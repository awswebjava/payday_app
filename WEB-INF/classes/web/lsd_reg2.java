package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.lsd_reg2", "/web.lsd_reg2"})
public final  class lsd_reg2 extends GXWebObjectStub
{
   public lsd_reg2( )
   {
   }

   public lsd_reg2( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( lsd_reg2.class ));
   }

   public lsd_reg2( int remoteHandle ,
                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new lsd_reg2_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new lsd_reg2_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "LSD_reg2";
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

