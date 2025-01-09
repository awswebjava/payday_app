package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.empresareligionesww", "/web.empresareligionesww"})
public final  class empresareligionesww extends GXWebObjectStub
{
   public empresareligionesww( )
   {
   }

   public empresareligionesww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( empresareligionesww.class ));
   }

   public empresareligionesww( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new empresareligionesww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new empresareligionesww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Empresa Religiones";
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

