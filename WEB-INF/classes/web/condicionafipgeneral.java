package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.condicionafipgeneral", "/web.condicionafipgeneral"})
public final  class condicionafipgeneral extends GXWebObjectStub
{
   public condicionafipgeneral( )
   {
   }

   public condicionafipgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( condicionafipgeneral.class ));
   }

   public condicionafipgeneral( int remoteHandle ,
                                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new condicionafipgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new condicionafipgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Condicion AFIPGeneral";
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

