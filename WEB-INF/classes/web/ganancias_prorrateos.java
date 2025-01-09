package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.ganancias_prorrateos", "/web.ganancias_prorrateos"})
public final  class ganancias_prorrateos extends GXWebObjectStub
{
   public ganancias_prorrateos( )
   {
   }

   public ganancias_prorrateos( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( ganancias_prorrateos.class ));
   }

   public ganancias_prorrateos( int remoteHandle ,
                                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new ganancias_prorrateos_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new ganancias_prorrateos_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Ganancias prorrateo de bonos y saldos de pagos a cuenta";
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

