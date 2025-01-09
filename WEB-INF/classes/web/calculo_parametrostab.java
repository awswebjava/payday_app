package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.calculo_parametrostab", "/web.calculo_parametrostab"})
public final  class calculo_parametrostab extends GXWebObjectStub
{
   public calculo_parametrostab( )
   {
   }

   public calculo_parametrostab( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( calculo_parametrostab.class ));
   }

   public calculo_parametrostab( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new calculo_parametrostab_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new calculo_parametrostab_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Calculo_parametros Tab";
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

