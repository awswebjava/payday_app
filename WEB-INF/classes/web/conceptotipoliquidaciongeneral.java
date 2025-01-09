package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.conceptotipoliquidaciongeneral", "/web.conceptotipoliquidaciongeneral"})
public final  class conceptotipoliquidaciongeneral extends GXWebObjectStub
{
   public conceptotipoliquidaciongeneral( )
   {
   }

   public conceptotipoliquidaciongeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( conceptotipoliquidaciongeneral.class ));
   }

   public conceptotipoliquidaciongeneral( int remoteHandle ,
                                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new conceptotipoliquidaciongeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new conceptotipoliquidaciongeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Concepto Tipo Liquidacion General";
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

