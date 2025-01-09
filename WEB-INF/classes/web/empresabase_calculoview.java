package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.empresabase_calculoview", "/web.empresabase_calculoview"})
public final  class empresabase_calculoview extends GXWebObjectStub
{
   public empresabase_calculoview( )
   {
   }

   public empresabase_calculoview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( empresabase_calculoview.class ));
   }

   public empresabase_calculoview( int remoteHandle ,
                                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new empresabase_calculoview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new empresabase_calculoview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Empresabase_calculo View";
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

