package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.tipo_obligacionview", "/web.tipo_obligacionview"})
public final  class tipo_obligacionview extends GXWebObjectStub
{
   public tipo_obligacionview( )
   {
   }

   public tipo_obligacionview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipo_obligacionview.class ));
   }

   public tipo_obligacionview( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipo_obligacionview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipo_obligacionview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "tipo_obligacion View";
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

