package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.liquidacionajusteww", "/web.liquidacionajusteww"})
public final  class liquidacionajusteww extends GXWebObjectStub
{
   public liquidacionajusteww( )
   {
   }

   public liquidacionajusteww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( liquidacionajusteww.class ));
   }

   public liquidacionajusteww( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new liquidacionajusteww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new liquidacionajusteww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Liquidacion Ajuste";
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

