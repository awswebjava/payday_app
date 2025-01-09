package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.origengeneral", "/web.origengeneral"})
public final  class origengeneral extends GXWebObjectStub
{
   public origengeneral( )
   {
   }

   public origengeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( origengeneral.class ));
   }

   public origengeneral( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new origengeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new origengeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Origen General";
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

