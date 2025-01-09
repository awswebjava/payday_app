package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.liquidacionajustedetallewc", "/web.liquidacionajustedetallewc"})
public final  class liquidacionajustedetallewc extends GXWebObjectStub
{
   public liquidacionajustedetallewc( )
   {
   }

   public liquidacionajustedetallewc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( liquidacionajustedetallewc.class ));
   }

   public liquidacionajustedetallewc( int remoteHandle ,
                                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new liquidacionajustedetallewc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new liquidacionajustedetallewc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Liquidacion Ajustedetalle WC";
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

