package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.liquidacionajustegeneral", "/web.liquidacionajustegeneral"})
public final  class liquidacionajustegeneral extends GXWebObjectStub
{
   public liquidacionajustegeneral( )
   {
   }

   public liquidacionajustegeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( liquidacionajustegeneral.class ));
   }

   public liquidacionajustegeneral( int remoteHandle ,
                                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new liquidacionajustegeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new liquidacionajustegeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Liquidacion Ajuste General";
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

