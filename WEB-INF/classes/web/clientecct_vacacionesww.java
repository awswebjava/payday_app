package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.clientecct_vacacionesww", "/web.clientecct_vacacionesww"})
public final  class clientecct_vacacionesww extends GXWebObjectStub
{
   public clientecct_vacacionesww( )
   {
   }

   public clientecct_vacacionesww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( clientecct_vacacionesww.class ));
   }

   public clientecct_vacacionesww( int remoteHandle ,
                                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new clientecct_vacacionesww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new clientecct_vacacionesww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Cliente CCT_vacaciones";
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

