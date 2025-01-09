package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.conceptomotivosegresogeneral", "/web.conceptomotivosegresogeneral"})
public final  class conceptomotivosegresogeneral extends GXWebObjectStub
{
   public conceptomotivosegresogeneral( )
   {
   }

   public conceptomotivosegresogeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( conceptomotivosegresogeneral.class ));
   }

   public conceptomotivosegresogeneral( int remoteHandle ,
                                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new conceptomotivosegresogeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new conceptomotivosegresogeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Concepto Motivos Egreso General";
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

