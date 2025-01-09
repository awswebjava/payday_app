package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.verliqretro2", "/web.verliqretro2"})
public final  class verliqretro2 extends GXWebObjectStub
{
   public verliqretro2( )
   {
   }

   public verliqretro2( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( verliqretro2.class ));
   }

   public verliqretro2( int remoteHandle ,
                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new verliqretro2_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new verliqretro2_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Liquidacion Detalle";
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

