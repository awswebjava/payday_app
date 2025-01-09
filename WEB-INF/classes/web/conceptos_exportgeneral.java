package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.conceptos_exportgeneral", "/web.conceptos_exportgeneral"})
public final  class conceptos_exportgeneral extends GXWebObjectStub
{
   public conceptos_exportgeneral( )
   {
   }

   public conceptos_exportgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( conceptos_exportgeneral.class ));
   }

   public conceptos_exportgeneral( int remoteHandle ,
                                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new conceptos_exportgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new conceptos_exportgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Conceptos_export General";
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

