package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.liqimportarauxtrn", "/web.liqimportarauxtrn"})
public final  class liqimportarauxtrn extends GXWebObjectStub
{
   public liqimportarauxtrn( )
   {
   }

   public liqimportarauxtrn( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( liqimportarauxtrn.class ));
   }

   public liqimportarauxtrn( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new liqimportarauxtrn_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new liqimportarauxtrn_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Liq Importar Aux Trn";
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
      return "empresa_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

