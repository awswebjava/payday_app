package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.liquidacionlegajo", "/web.liquidacionlegajo"})
public final  class liquidacionlegajo extends GXWebObjectStub
{
   public liquidacionlegajo( )
   {
   }

   public liquidacionlegajo( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( liquidacionlegajo.class ));
   }

   public liquidacionlegajo( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new liquidacionlegajo_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new liquidacionlegajo_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Liquidacion Legajo";
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

