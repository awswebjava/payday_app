package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.tipo_obligaciongeneral", "/web.tipo_obligaciongeneral"})
public final  class tipo_obligaciongeneral extends GXWebObjectStub
{
   public tipo_obligaciongeneral( )
   {
   }

   public tipo_obligaciongeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipo_obligaciongeneral.class ));
   }

   public tipo_obligaciongeneral( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipo_obligaciongeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipo_obligaciongeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "tipo_obligacion General";
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

