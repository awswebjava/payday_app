package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.tipoliquidacionww", "/web.tipoliquidacionww"})
public final  class tipoliquidacionww extends GXWebObjectStub
{
   public tipoliquidacionww( )
   {
   }

   public tipoliquidacionww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipoliquidacionww.class ));
   }

   public tipoliquidacionww( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipoliquidacionww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipoliquidacionww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Tipo Liquidacion";
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

