package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.clientecct_vacaciones", "/web.clientecct_vacaciones"})
public final  class clientecct_vacaciones extends GXWebObjectStub
{
   public clientecct_vacaciones( )
   {
   }

   public clientecct_vacaciones( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( clientecct_vacaciones.class ));
   }

   public clientecct_vacaciones( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new clientecct_vacaciones_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new clientecct_vacaciones_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Cliente CCT_vacaciones";
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

