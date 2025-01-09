package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.empresabase_calculo", "/web.empresabase_calculo"})
public final  class empresabase_calculo extends GXWebObjectStub
{
   public empresabase_calculo( )
   {
   }

   public empresabase_calculo( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( empresabase_calculo.class ));
   }

   public empresabase_calculo( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new empresabase_calculo_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new empresabase_calculo_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "";
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

