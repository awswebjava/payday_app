package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.situaciongeneral", "/web.situaciongeneral"})
public final  class situaciongeneral extends GXWebObjectStub
{
   public situaciongeneral( )
   {
   }

   public situaciongeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( situaciongeneral.class ));
   }

   public situaciongeneral( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new situaciongeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new situaciongeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Situacion General";
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

