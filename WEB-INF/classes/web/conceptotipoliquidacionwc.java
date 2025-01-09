package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.conceptotipoliquidacionwc", "/web.conceptotipoliquidacionwc"})
public final  class conceptotipoliquidacionwc extends GXWebObjectStub
{
   public conceptotipoliquidacionwc( )
   {
   }

   public conceptotipoliquidacionwc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( conceptotipoliquidacionwc.class ));
   }

   public conceptotipoliquidacionwc( int remoteHandle ,
                                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new conceptotipoliquidacionwc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new conceptotipoliquidacionwc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Concepto Tipo Liquidacion WC";
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

