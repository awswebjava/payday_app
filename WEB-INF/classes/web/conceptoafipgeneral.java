package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.conceptoafipgeneral", "/web.conceptoafipgeneral"})
public final  class conceptoafipgeneral extends GXWebObjectStub
{
   public conceptoafipgeneral( )
   {
   }

   public conceptoafipgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( conceptoafipgeneral.class ));
   }

   public conceptoafipgeneral( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new conceptoafipgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new conceptoafipgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Concepto AFIPGeneral";
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

