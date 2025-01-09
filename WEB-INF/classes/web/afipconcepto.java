package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.afipconcepto", "/web.afipconcepto"})
public final  class afipconcepto extends GXWebObjectStub
{
   public afipconcepto( )
   {
   }

   public afipconcepto( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( afipconcepto.class ));
   }

   public afipconcepto( int remoteHandle ,
                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new afipconcepto_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new afipconcepto_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "AFIPConcepto";
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

