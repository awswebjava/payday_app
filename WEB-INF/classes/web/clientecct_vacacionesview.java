package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.clientecct_vacacionesview", "/web.clientecct_vacacionesview"})
public final  class clientecct_vacacionesview extends GXWebObjectStub
{
   public clientecct_vacacionesview( )
   {
   }

   public clientecct_vacacionesview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( clientecct_vacacionesview.class ));
   }

   public clientecct_vacacionesview( int remoteHandle ,
                                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new clientecct_vacacionesview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new clientecct_vacacionesview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Cliente CCT_vacaciones View";
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

