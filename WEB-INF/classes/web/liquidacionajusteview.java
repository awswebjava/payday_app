package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.liquidacionajusteview", "/web.liquidacionajusteview"})
public final  class liquidacionajusteview extends GXWebObjectStub
{
   public liquidacionajusteview( )
   {
   }

   public liquidacionajusteview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( liquidacionajusteview.class ));
   }

   public liquidacionajusteview( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new liquidacionajusteview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new liquidacionajusteview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Liquidacion Ajuste View";
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

