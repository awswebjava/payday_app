package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.liqimportarauxtrnww", "/web.liqimportarauxtrnww"})
public final  class liqimportarauxtrnww extends GXWebObjectStub
{
   public liqimportarauxtrnww( )
   {
   }

   public liqimportarauxtrnww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( liqimportarauxtrnww.class ));
   }

   public liqimportarauxtrnww( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new liqimportarauxtrnww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new liqimportarauxtrnww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Liq Importar Aux Trn";
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

