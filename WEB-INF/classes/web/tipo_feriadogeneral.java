package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.tipo_feriadogeneral", "/web.tipo_feriadogeneral"})
public final  class tipo_feriadogeneral extends GXWebObjectStub
{
   public tipo_feriadogeneral( )
   {
   }

   public tipo_feriadogeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipo_feriadogeneral.class ));
   }

   public tipo_feriadogeneral( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipo_feriadogeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipo_feriadogeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "tipo_feriado General";
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

