package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.tipo_feriadoview", "/web.tipo_feriadoview"})
public final  class tipo_feriadoview extends GXWebObjectStub
{
   public tipo_feriadoview( )
   {
   }

   public tipo_feriadoview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipo_feriadoview.class ));
   }

   public tipo_feriadoview( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipo_feriadoview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipo_feriadoview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "tipo_feriado View";
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

