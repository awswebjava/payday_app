package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.templaterecibogeneral", "/web.templaterecibogeneral"})
public final  class templaterecibogeneral extends GXWebObjectStub
{
   public templaterecibogeneral( )
   {
   }

   public templaterecibogeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( templaterecibogeneral.class ));
   }

   public templaterecibogeneral( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new templaterecibogeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new templaterecibogeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Template Recibo General";
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
