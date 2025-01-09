package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.liqimportarauxtrnview", "/web.liqimportarauxtrnview"})
public final  class liqimportarauxtrnview extends GXWebObjectStub
{
   public liqimportarauxtrnview( )
   {
   }

   public liqimportarauxtrnview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( liqimportarauxtrnview.class ));
   }

   public liqimportarauxtrnview( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new liqimportarauxtrnview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new liqimportarauxtrnview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Liq Importar Aux Trn View";
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

