package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.calculo_parametros", "/web.calculo_parametros"})
public final  class calculo_parametros extends GXWebObjectStub
{
   public calculo_parametros( )
   {
   }

   public calculo_parametros( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( calculo_parametros.class ));
   }

   public calculo_parametros( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new calculo_parametros_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new calculo_parametros_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Calculo_parametros";
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

