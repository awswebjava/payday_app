package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.afipconceptogeneral", "/web.afipconceptogeneral"})
public final  class afipconceptogeneral extends GXWebObjectStub
{
   public afipconceptogeneral( )
   {
   }

   public afipconceptogeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( afipconceptogeneral.class ));
   }

   public afipconceptogeneral( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new afipconceptogeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new afipconceptogeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "AFIPConcepto General";
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

